public class SurrogateOutputStream extends ObjectOutputStream {

    public SurrogateOutputStream(OutputStream out) throws IOException {
        super(out);
        enableReplaceObject(true);
    }

    protected SurrogateOutputStream() throws IOException, SecurityException {
        super();
        enableReplaceObject(true);
    }

    @Override
    protected Object replaceObject(Object obj) throws IOException {
        if (obj instanceof Area) {
            return new AreaSurrogate((Area) obj);
        } else {
            return super.replaceObject(obj);
        }
    }
}
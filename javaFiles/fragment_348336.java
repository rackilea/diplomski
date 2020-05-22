public class SurrogateObjectOutputStream extends ObjectOutputStream {

    public SurrogateObjectOutputStream(OutputStream out) throws IOException {
        super(out);
        enableReplaceObject(true);
    }

    protected SurrogateObjectOutputStream() throws IOException, SecurityException {
        super();
        enableReplaceObject(true);
    }

    @Override
    protected Object replaceObject(Object obj) throws IOException {
        if (obj instanceof Pojo) {
            return new PojoSurrogate((Pojo) obj);
        } else return super.replaceObject(obj);
    } 
}
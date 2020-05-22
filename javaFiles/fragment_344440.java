public class ObjOutputStream extends ObjectOutputStream {

    /**
     * @param out
     * @throws IOException
     */
    public ObjOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    /* (non-Javadoc)
     * @see java.io.ObjectOutputStream#writeStreamHeader()
     */
    @Override
    protected void writeStreamHeader() throws IOException {
    }
}
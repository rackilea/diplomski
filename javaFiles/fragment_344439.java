public class ObjInputStream extends ObjectInputStream {
    /**
     * @param in
     * @throws IOException
     */
    public ObjInputStream(InputStream in) throws IOException {
        super(in);
    }

    /* (non-Javadoc)
     * @see java.io.ObjectInputStream#readStreamHeader()
     */
    @Override
    protected void readStreamHeader() throws IOException, StreamCorruptedException {
    }
}
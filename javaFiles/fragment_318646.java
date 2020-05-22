public class MySaver{
    private PrintWriter innerWriter;
    public MySaver(Writer writer)
    {
    this.innerWriter = new PrintWriter(writer);
    }

    public void save(String c) throws IOException {
        innerWriter.write(c);
    }

}
public Test() {
    try {
        channel = new RandomAccessFile(new File(path), "rw").getChannel();
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();

        System.out.println(channel.isOpen());
        NonClosingInputStream ncis = new NonClosingInputStream(Channels.newInputStream(channel));
        doc = dBuilder.parse(ncis);
        System.out.println(channel.isOpen());
        // Closes here.
        ncis.reallyClose();
        channel.close(); //Redundant
    } catch (IOException | ParserConfigurationException | SAXException e) {
        e.printStackTrace();
    }
}

class NonClosingInputStream extends FilterInputStream {

    public NonClosingInputStream(InputStream it) {
        super(it);
    }

    @Override
    public void close() throws IOException {
        // Do nothing.
    }

    public void reallyClose() throws IOException {
        // Actually close.
        in.close();
    }
}
public static void main(String[] args) {
    RssType rss = new RssType();
    rss.setVersion("1.0");
    ChannelType channel = new ChannelType();
    channel.setTitle("Test title");
    // Set the rest of the variables
    rss.setChannel(channel);

    //do the same for you other types then
    //convert it to xml

    Serializer serializer = new Persister();
    File result = new File("rss.xml");

    serializer.write(rss, result);
}
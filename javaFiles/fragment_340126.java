try {
    Reader reader = new FileReader(pomXmlFile);
    Model model;
    try {
        final MavenXpp3Reader xpp3Reader = new MavenXpp3Reader();
        model = xpp3Reader.read(reader);
    } finally {
        reader.close();
    }
    List<License> licenses = model.getLicenses();
} catch (XmlPullParserException ex) {
    ex.printStackTrace();
} catch (IOException ex) {
    ex.printStackTrace();
}
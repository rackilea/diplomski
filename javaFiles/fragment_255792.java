public static void main(String[] args) throws JAXBException {
    JAXBContext ctx = JAXBContext.newInstance(Config.class);
    Unmarshaller um = ctx.createUnmarshaller();
    JAXBElement<Config> element = um.unmarshal(new StreamSource(new File("config.xml")), Config.class);
    Config config = element.getValue();
    for (FileEntry file : config.entries) {
        System.out.println(file.filepath);
        System.out.println(file.inputfile);
        System.out.println(file.outputfile);
        System.out.println(file.cellrange);
    }
}
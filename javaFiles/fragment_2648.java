public static MessagesStorage unmarshallingMessages(File file){
        XStream xStream = new XStream();
        xStream.processAnnotations(new Class[]{MessagesStorage.class,Message.class});
        xStream.registerConverter(new ComPortConverter());
        return (MessagesStorage) xStream.fromXML(file);
    }
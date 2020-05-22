public static void main(String[] args) throws JAXBException, FileNotFoundException{
        JAXBContext jaxbContext = JAXBContext.newInstance(ResponseKeysBean.class);
        Unmarshaller um = jaxbContext.createUnmarshaller();
        ResponseKeysBean keyObj = (ResponseKeysBean) um.unmarshal(new FileReader(new File("./configurationfiles/testconfig.xml")));

        System.out.println(keyObj.getKeyList());
        System.out.println(keyObj.getStatus());

    }
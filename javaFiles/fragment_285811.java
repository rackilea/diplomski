/**
     * @param args the command line arguments
     * @throws javax.xml.bind.JAXBException
     */
    public static void main(String[] args) throws JAXBException {
        // TODO code application logic here
        try {

            File file = new File("file.xml");

            if (file.exists()) {
                JAXBContext jaxbContext = JAXBContext.newInstance(CC5Response.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                CC5Response response = (CC5Response) jaxbUnmarshaller.unmarshal(file);

                if (response != null) {
                    System.out.println("*************" + response.getAuthCode());
                    System.out.println("*************" + response.getErrMsg());
                    System.out.println("*************" + response.getGroupId());
                    System.out.println("*************" + response.getOrderId());
                    System.out.println("*************" + response.getResponse());
                    //you can get any field from Exta class 
                    System.out.println("*************" + response.getExtra());
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
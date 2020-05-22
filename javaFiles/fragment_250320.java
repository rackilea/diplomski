public static void main(String[] args) {

        try {
            File file = new File("trees.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Trees.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Trees trees = (Trees) jaxbUnmarshaller.unmarshal(file);
            System.out.println(trees);

         } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
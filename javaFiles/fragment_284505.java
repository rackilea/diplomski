public static void main(String[] args) throws Exception{
    JAXBContext context = JAXBContext.newInstance(A.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    Object obj = unmarshaller.unmarshal(new File("input.xml"));
    System.out.println(obj);
}
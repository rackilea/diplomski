/**
 * @param args
 */
public static void main(String[] args) {
    File file = new File("C:\\kar\\file1.xml");
    try{
    JAXBContext jaxbContext = JAXBContext.newInstance(Objects.class);
    Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();


    Objects listcustomers = (Objects) jaxbUnMarshaller.unmarshal(file);
    List<Cuobject> cusmters=listcustomers.getCuobject();
    Iterator<Cuobject> it = cusmters.iterator();
    while(it.hasNext()){
        Cuobject customer = it.next();
        System.out.println("Customer ID: "+ customer.typeId + " Customer email" + customer.objectId);
        List<ObjectAttribute> details =customer.objectAttribute;
        Iterator<ObjectAttribute> it1 = details.iterator();
        System.out.println(" -------Details------------");
        while(it1.hasNext()){
            ObjectAttribute detail = it1.next();

            System.out.println(detail.attributeId + " =" + detail.value);
        }
    }
    }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
}
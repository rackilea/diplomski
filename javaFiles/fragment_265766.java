public static void main(String[] args) throws Throwable {

        JAXBContext jc =  JAXBContext.newInstance(Root.class, Item.class);
        Root r = new Root();

        Item i = new Item();
        i.setLabel("This is a LIST item");
        i.setType("List");

        Item i2 = new Item();
        i2.setLabel("Upper");
        i2.setType("string");
        i2.getContent().add("ABC");

        i.getContent().add(i2);

        Item i3 = new Item();
        i3.setLabel("Lower");
        i3.setType("string");
        i3.getContent().add("abc");

        i.getContent().add(i3);

        Item i4 = new Item();
        i4.setNum("1");
        i4.setType("list");

        Item i5 = new Item();
        i5.setLabel("a");
        i5.setType("other");
        i5.getContent().add("aaaaa");


        i4.getContent().add(i5);

        i.getContent().add(i4);


        r.getItems().add(i);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
        marshaller.marshal(r, System.out);


}
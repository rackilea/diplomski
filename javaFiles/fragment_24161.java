public class JAXBArrayWriter {

    public static class Item {
        @XmlValue
        protected String value;

        public Item() {}

        public Item(String value) {
            this.value = value;
        }
    }

    public static void main (String [] args) throws Exception {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("one"));
        items.add(new Item("two"));
        JAXBContext jc = JAXBContext.newInstance(Item[].class);
        JAXBElement<Item[]> root = new JAXBElement<Item[]>(new QName("items"), 
                Item[].class, items.toArray(new Item[items.size()]));
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(root, writer);
        System.out.println(writer.toString());
    }
}
public class Main {
    public static void main(String[] args) throws JAXBException {

        // initialize JAXB
        JAXBContext context = JAXBContext.newInstance(Model.class, Definitions.class);

        // Unmarshal input XML into Java object
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Model model = (Model) unmarshaller.unmarshal(Main.class.getClassLoader().getResourceAsStream("input.xml"));

        // Map old Java object to new Java object
        List<Task> tasks = new ArrayList<Task>();
        for (Node node : model.getNodes()) {
            tasks.add(new Task(node.getId()));
        }

        // Marshal new Java object into XML
        Definitions definitions = new Definitions(new Process(model.getId(), tasks));

        StringWriter sw = new StringWriter();

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.marshal(definitions, sw);

        System.out.println(sw.toString());
    }
}
...
OutputStream out = new ByteArrayOutputStream();

JAXBContext context = JAXBContext.newInstance(Kunde.class);
Marshaller m = context.createMarshaller();
m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
m.marshal(kunde, out);
out.close();

Form form = new Form();
form.add("entity", out.toString());
...
...
OutputStream out = new ByteArrayOutputStream();

ObjectMapper mapper = new ObjectMapper();
mapper.writeValue(out, kunde);
out.close();

Form form = new Form();
form.add("entity", out.toString());
...
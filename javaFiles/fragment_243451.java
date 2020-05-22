jsonMapper = new ObjectMapper();
A a = jsonMapper.readValue(new StringReader(source), A.class);
B b = dozerMapper.map(a, B.class);
StringWriter sw = new StringWriter();
jsonMapper.writeValue(sw, b);
target = sw.toString();
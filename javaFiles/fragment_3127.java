JAXBContext ctx = JAXBContext.newInstance(Car.class, V6Engine.class, V12Engine.class);
Unmarshaller um = ctx.createUnmarshaller();
Car c = (Car)um.unmarshal(new File("file.xml"));

assert "BMW".equals(c.brand);
assert c.engine instanceof V12Engine;
assert ((V12Engine)c.engine).horsePowers == 300;
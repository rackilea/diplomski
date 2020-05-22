TransformerFactory tf = TransformerFactory.newInstance();
StreamSource xslt = new StreamSource(new FileInputStream("my-xslt.xml"));
Transformer t = tf.newTransformer(xslt);

JAXBContext jc = JAXBContext.newInstance(MyClass.class);
JAXBSource source = new JAXBSource(jaxbContext1, foo);
JAXBResult result = new JAXBResult(jaxbContext2);
t.transform(source, result);
Bar bar = (Bar) result.getResult();
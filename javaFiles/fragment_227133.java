final File f = new File("test.xml");

HowToRenderEmptyTag example = new HowToRenderEmptyTag("");

Serializer ser = new Persister(new AnnotationStrategy()); // Don't forget AnnotationStrategy here!
ser.write(example, f);
/* Please note the 'new AnnotationStrategy()' - it's important! */
final Serializer ser = new Persister(new AnnotationStrategy());

/* Serialize */
PickXtra px = new PickXtra("ExampleKEY", "ExampleVALUE");
ser.write(px, System.out);

System.out.println("\n");

/* Deserialize */
final String xml = "<PickLineXtra ExampleKEY=\"ExampleVALUE\"/>";
PickXtra px2 = ser.read(PickXtra.class, xml);

System.out.println(px2);
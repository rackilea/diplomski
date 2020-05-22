InputSource source1 = new InputSource(new StringReader(xml));
InputSource source2 = new InputSource(new StringReader(xml));

String msg = xpath.evaluate("/resp/msg", source);
String status = xpath.evaluate("/resp/status", source2);

System.out.println("msg=" + msg + ";" + "status=" + status);
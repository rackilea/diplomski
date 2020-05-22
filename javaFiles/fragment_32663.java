final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("file.xml"));

final Set<NodeWrapper> inimesteList = new TreeSet<NodeWrapper>();

final NodeList isa = doc.getElementsByTagName("isa");
for (int i = 0; i < isa.getLength(); i++) {
    inimesteList.add(new NodeWrapper(isa.item(i)));
}
final NodeList ema = doc.getElementsByTagName("ema");
for (int i = 0; i < ema.getLength(); i++) {
    inimesteList.add(new NodeWrapper(ema.item(i)));
}
final NodeList isik = doc.getElementsByTagName("isik");
for (int i = 0; i < isik.getLength(); i++) {
    inimesteList.add(new NodeWrapper(isik.item(i)));
}
System.out.println();
System.out.println("Total: " + inimesteList.size());

for (final NodeWrapper nw : inimesteList) {
    System.out.println(nw);
}
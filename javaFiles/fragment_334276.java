LineNumberReader r = new LineNumberReader(new FileReader("input.txt"));
String l;

while ((l = r.readLine()) != null) {
    Scanner s = new Scanner(l);

    while (s.hasNext()) {
        System.out.println("Line " + r.getLineNumber() + ": " + s.next());
    }
}
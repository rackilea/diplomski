r = new LineNumberReader(new FileReader("input.txt"));
s = new Scanner(r);

while (s.hasNext()) {
    System.out.println("Line " + r.getLineNumber() + ": " + s.next());
}
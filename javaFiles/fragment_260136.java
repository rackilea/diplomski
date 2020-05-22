Scanner scanner = new Scanner ("5 4 34");
List <Integer> list = new ArrayList <Integer> ();
while (scanner.hasNextInt()) {
    int v = scanner.nextInt ();
    list.add (v);
    System.out.println (v);
}
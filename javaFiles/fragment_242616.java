final Scanner in = new Scanner(System.in);
in.useDelimiter("");

while (in.hasNext()){
    final String next = in.next();
    for(int i = 0; i < next.length(); i++) {
        System.out.println(next.codePointAt(i));
    }
}
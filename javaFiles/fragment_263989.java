Scanner reader = new Scanner(System.in);
while(reader.hasNext()) {
  String s = reader.nextLine();
  if(s.trim().length() > 0) {
    System.out.println (process(s));
  }
}
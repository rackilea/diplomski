for (char c : a){
  if (Character.isDigit(c)) {
    String z = Character.toString(c);
    x = Integer.parseInt(z);
    System.out.println("YES");
  }
}
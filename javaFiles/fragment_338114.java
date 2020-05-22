Scanner inp = new Scanner(System.in);
System.out.print("In:");
String s = inp.nextLine();

for (int i = s.length() - 1; i>=0; i--) {
   if (s.charAt() != ' ') {System.out.print(s.charAt(i));}
}
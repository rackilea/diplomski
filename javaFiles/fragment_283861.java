String multilinetext =
    "Line1\n" +
    "Line2\n" +
    "\n" +
    "Line4\n" +
    "\n";
Scanner sc = new Scanner(multilinetext);
while (sc.hasNextLine()) {
    System.out.println("[" + sc.nextLine() + "]");
}
/* prints 
[Line1]
[Line2]
[]
[Line4]
[]
*/
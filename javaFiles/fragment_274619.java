String s = "Some text. More, more text. /* \n|| This is a comments section in pl/sql code...||\n|| Which i don't want to store..               ||\n*/ SOME HERE";
Scanner in1 = new Scanner(s);
ArrayList<String> Code1 = new ArrayList<String>();
in1.useDelimiter("/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/|[\\p{javaWhitespace}.,]+");
while (in1.hasNext()) {
    System.out.println(in1.next().toLowerCase());
}
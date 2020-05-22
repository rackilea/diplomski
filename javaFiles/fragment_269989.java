Scanner sc = new Scanner(System.in);
System.out.println("ENter a paragraph:");
String input = sc.nextLine();
String[] sentences = input.split("\\.");
for (int i = 0; i < sentences.length; i++) {
    System.out.println(sentences[i]);
}
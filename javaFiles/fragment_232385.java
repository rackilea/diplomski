Scanner cumle = new Scanner(System.in);
System.out.println("Enter the sentence u want to replace :");
String str1 = cumle.nextLine();

if (str1.contains("replace")) {
    str1 = str1.replace("replace", "Hi");
    System.out.println("Replaced Sentence: " + str1);
} else {
    System.out.println("Sentence doesn't contains that...");
}
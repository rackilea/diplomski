public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the document text : ");
    String text = input.nextLine();
    Document object = new Document(text);
    object.sort(terms);
    System.out.println("--- AFTER SORT ----");
    for (String s : terms)
        System.out.println(s);

}
Scanner input=new Scanner(System.in);
    System.out.println("Enter a sentence with words including java");
    String sentence=input.nextLine();

    String find="java";
    String replace="JAVA";
    String result="";

    result = sentence.toLowerCase();
    result = result.replace(find,replace);
    System.out.println(result);
}
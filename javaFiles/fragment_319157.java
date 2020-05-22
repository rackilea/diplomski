Scanner input=new Scanner(System.in);
    System.out.println("Enter a sentence with words including java");
    String sentence=input.nextLine();

    String find="java";
    String replace="JAVA";
    String result="";
    int n;
    do{
        //for you to ignore(converts the sentence to lowercase) either lower or upper case in your sentence then do the nxt process
        sentence = sentence.toLowerCase();

        n=sentence.indexOf(find);
        if(n!=-1){
            result =sentence.substring(0,n);
            result=result +replace;
            result = result + sentence.substring(n+find.length());
            sentence=result;            
        }
    }while(n!=-1);
    System.out.println(sentence);
}
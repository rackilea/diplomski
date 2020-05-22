Scanner scan = new Scanner(System.in);
String str="";
String exit="exit";

System.out.println("Please enter some words : ");
while(true){
    str=scan.next();
    if(str.equalsIgnoreCase(exit)) break;
    System.out.println(str);
}

scan.nextLine(); // consume rest of the string after exit word
System.out.println("Please enter a sentnce : ");
String sentence1 = scan.nextLine(); // get sentence

System.out.println("the word you entered is : " + sentence1);
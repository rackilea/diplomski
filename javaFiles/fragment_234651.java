String text="Some text +with -delimiters *described /above";
Scanner in=new Scanner(text);
in.useDelimiter("\\+|\\-|\\*|/"); // +,-,* are metacharacters in regex
                                  // to escape its special meaning we need 
                                  // to use "\\" before each of them
int counter=0;
while(in.hasNext())
    System.out.println(counter++ +") "+ in.next());
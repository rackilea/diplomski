public static void main(String[]args){
System.out.println("How many columns?");
int columns = new Scanner(System.in).nextInt();

for(int i=0; i<=columns; i++){
  String toPrint = "x";
  for(int cols=0; cols<i; cols++){
      toPrint+=" ";
  }
  System.out.println(toPrint+"x");

}

}
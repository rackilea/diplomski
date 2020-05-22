Scanner s=new Scanner(System.in);

System.out.println("Anota una Frase: ");
String str=s.nextLine();
int i = 0;
while(i<=str.length()) {
    String str2 =  str.substring(0,i);      
    System.out.println(str2);
    i++;
}
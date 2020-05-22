System.out.println("enter the statment you wish to encode");

String plaintext=sc.nextLine();
int [] a=new int[plaintext.length()];
for ( int i = 0; i < plaintext.length(); i++) {
   char c = plaintext.charAt(i);
   int ascii = (int) c;
   System.out.print(ascii); 
   a[i]=ascii;
}
System.out.println("||||");

for(int i=0; i<plaintext.length(); i++){
    System.out.print(a[i]^6 ); 
}
System.out.println("||||");

String str = Arrays.toString(a);
System.out.println("str.."+str);

String str2 = "";
for ( int c = 0; c < a.length(); c++) {
    str2 += (char)a[c];
}

System.out.println("str2.."+str2);
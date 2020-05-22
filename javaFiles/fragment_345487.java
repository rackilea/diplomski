System.out.print("Total Line : ");
a = Masuk.readLine();
n = Integer.parseInt(a);

String[] Alltext = new String[n];
for(int i = 1;i<=n;i++) {

System.out.print("Input number : ");
a = Masuk.readLine();
n = Integer.parseInt(a);

System.out.print("Input Text : ");
a = Masuk.readLine();

 Alltext[i-1]= a+" "+n;//i-1 because loop starts from 1

}
for(String i : Alltext){
 System.out.println(i);
}
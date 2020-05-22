Scanner sc=new Scanner(System.in);
 String str="";
 for(int i=0;i<3;i++){
   String s=sc.next();
   str = str + s;       //append to a string instead of string buffer.
 }
 String a[] = str.split(" ");
 for(int i=0;i<a.length;i++){
     System.out.println(a[i]);
 }
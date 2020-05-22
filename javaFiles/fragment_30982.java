Scanner sc=new Scanner(System.in);
 String str="";
 for(int i=0;i<3;i++){
   String s=sc.next();
   str = str + s+"\n";    //Just string instead of string buffer.
 }
 System.out.println(str);
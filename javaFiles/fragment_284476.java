Scanner s=new Scanner(System.in);
boolean flag=true;
String pwd="";
while(flag) {
pwd=s.nextLine();
if(pwd.length()>8 && pwd.equals("IntendedWord"))
// set flag=false AND then continue your intended action...
else
System.out.println("Please try again");
}
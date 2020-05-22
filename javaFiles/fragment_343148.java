String Str = new String("3 5 3 -4 2 3");
String[] x = Str.split("-\\d+");

for (String retval: x){
   System.out.println(retval.trim());
}
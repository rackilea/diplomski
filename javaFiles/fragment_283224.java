String str ="André";
String toOctal ="";
for(char c : str.toCharArray()){
    toOctal += Integer.toOctalString(c)+" ";
}
System.out.println(toOctal);
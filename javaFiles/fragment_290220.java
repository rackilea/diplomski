String  stg = "\u2029My Actual String\u2029 \nMy Actual String";
Pattern pat = Pattern.compile("(?!(\\\\(u|U)\\w{4}|\\s))(\\w)+");
Matcher mat = pat.matcher(stg);
String out  =  "";
while(mat.find()){
    out+=mat.group()+" ";   
}
System.out.println(out);
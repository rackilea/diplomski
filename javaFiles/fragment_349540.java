String mystring = "<EQHO state=\"degraded\"...> at /NE[1]/EQHO[2]/@state to <EQHO state=\"working\"...> at /NE[1]/EQHO[1]/@state";
ArrayList<String> values = new ArrayList<String>();
while(mystring.indexOf("at /") < mystring.indexOf("/@")){
    String val = mystring.substring(mystring.indexOf("at /") + 4, mystring.indexOf("/@"));
    values.add(val);
    mystring = mystring.substring(mystring.indexOf("/@")+2);
}
System.out.println(values);
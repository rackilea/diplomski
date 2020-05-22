String[] data ={
        "XYZ12345678123456789123",          //123456789123
        "123456789123",                     //123456789123
        "XYZ12345678REF123456789123 ",      //REF123456789123
        "12345678912",                      //no match because not 12 digits
        "REF123456789123",                  //REF123456789123
        "REF12345678912",                   //no match because not 12 digits
        "XYZ12345678123456789123ABC",       //123456789123
        "XYZ123456789123",                  //no match
        "XYZ1234567891234",                 //no match
};


Pattern p = Pattern.compile("(?<!XYZ\\d{0,7})(?>REF[A-Z]*)?(\\d{3}+)(\\d{6}+)(\\d{3}+)");
for (String s:data){
    System.out.printf("%-30s",s);
    Matcher m = p.matcher(s);
    while (m.find())
        System.out.print("match: "+m.group());
    System.out.println();
}
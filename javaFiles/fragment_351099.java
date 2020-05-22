String[] array = {"122-555-1521", "155--122", "155,-", ".-12", "123.123."};
String pattern = "^(?:\\d+[.,-])*\\d+$";
for(String str : array){
    System.out.println(str+" "+str.matches(pattern));
}

122-555-1521 true
155--122     false
155,-        false
.-12         false
123.123.     false
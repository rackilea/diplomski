List<String> list = new ArrayList<>;
list.add("a");
list.add("b");
list.add("a");
list.add("b");

String stringArray = Arrays.toString(list.toArray()); 
String commaSepratedValues = stringArray.replaceAll("[","").replaceAll("]","");
for(String value : commaSepratedValues.split(",")){
    //here you can add it to SET<>
}
String listOfIntegers = ("1 5 9 12 15 50 80 121");
String integerToLookFor = ("12");
String[] splitArr = listOfIntegers.split("\\s");
for(String s: splitArr){
    if(s.equals(integerToLookFor)) {
        System.out.println("found: " + s);
        break; //breaks out of the loop
    }
}
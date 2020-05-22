Scanner scanner = new Scanner (new File ("stack.txt"));
int charFrequency = 0;
String value = "";
while (scanner.hasNext()){
    String tempValue = scanner.next();
    if ("".equals(value)) {
        value = tempValue;
        charFrequency ++;
    }
    else if (value.equals(tempValue)) {
        charFrequency ++;
    }
    else {
        System.out.println("Data: " +value+" Count: "+charFrequency);
        value = tempValue;  
        charFrequency = 1;
    }
}
System.out.println("Data :" +value+" Count: "+charFrequency);
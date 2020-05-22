String str="(1,6),(2,5),(7,10),(12,20)";

//convert to string array of numbers
String[] numbersStr = str.replaceAll("\\(","").replaceAll("\\)","").split(",");

//convert to int array of numbers
int[] numbers = new int[numbersStr.length];
for(int i = 0; i < numbersStr.length; ++i)
   numbers[i] = Integer.parseInt(numbersStr[i]);
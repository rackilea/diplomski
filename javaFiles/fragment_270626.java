String[][] mainArray = new String[1][];
String[] data = new String[3];

data[0] = "Hello";
data[1] = "World";
data[2] = "!";

mainArray[0] = data;

String[][] testArray = mainArray.clone();

for (int i = 0; i < testArray.length; i++) {
    testArray[i] = testArray[i].clone();
}

System.out.println("Main Array: " + Arrays.deepToString(mainArray));
System.out.println("test Array: " + Arrays.deepToString(testArray));

data[2] = "!!!!";

mainArray[0] = data;

System.out.println();
System.out.println("Main Array2: " + Arrays.deepToString(mainArray));
System.out.println("test Array2: " + Arrays.deepToString(testArray));
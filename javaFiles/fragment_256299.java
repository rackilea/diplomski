String[] inputArray = {"Juan", "Jhon", "Camil", "William", "Andrew", "Felip"};
for(int i = 1; i < inputArray.length; i++)  {
    String key = inputArray[i];
    int j = i - 1;

    while (j >= 0 && key.compareTo(inputArray[j]) < 0) {
        inputArray[j + 1] = inputArray[j];
        j--;
    }
    inputArray[j + 1] = key;
}
System.out.println(Arrays.toString(inputArray));
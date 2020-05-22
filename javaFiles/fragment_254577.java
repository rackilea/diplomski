int minValue = Integer.MAX_VALUE;
for (int i = 0; i < array.length; i++) {
    for (int j = 0; j < array.length; j++) {
        int value = array[i][j];
        if (averageElements < value && value < minValue) {
            minValue = value;
        }
    }
}
System.out.println("Smallest element array higher than average " + minValue);
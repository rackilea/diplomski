int maxValue = Integer.MIN_VALUE;
int indexMaxValueArray = 0;

for (int i = 0; i < moves.size(); i++) {
    if (someValue * moves.get(i)[2] > maxValue) {
        maxValue = someValue * moves.get(i)[2];
        indexMaxValueArray = i;
    }
}
System.out.println("maxValue = " + maxValue);
System.out.println("index of array in list = " + indexMaxValueArray);
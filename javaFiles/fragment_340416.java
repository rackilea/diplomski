public static int findMin(int[] numbers, int startIndex, int endIndex) {
        if(startIndex == endIndex){
            return numbers[startIndex];
        }
        int min = findMin(numbers, startIndex+1, endIndex);
        return  numbers[startIndex] < min ? numbers[startIndex] : min ;
}
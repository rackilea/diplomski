public static void main(String[] args) {
    int[] A={5,2,6,8},
            B={6,5,5,8,5,6};
    int[] count = new int[A.length]; // An array counting the occurences
    StringBuilder result = new StringBuilder(); // The String to be displayed. StringBuilder is better than String, when multiple concatenations occur.

    Arrays.sort(A); // Sorts array A in ascending order (by default).

    // This loop counts the occurence of each value of A inside B
    for (int i = 0; i <A.length; i++){
        for (int j = 0; j < B.length; j++){
            if (A[i] == B[j])
                count[i]++;
        }
        // After each value of A, add the number of occurence in the String
        result.append(A[i]).append(" (").append(count[i]).append(" times), ");
    }


    // Displays the String in the console, removing the last ", "
    System.out.println(result.substring(0,result.length()-2));

}
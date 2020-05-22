int[][] str2dArray = new int[str1dArray.length][str1dArray[0].length()];
for (int i = 0; i < str1dArray.length; i++) {
    str2dArray[i] = Arrays.stream(str1dArray[i].split("")).mapToInt(Integer::parseInt).toArray();

    // This also works without using Lambda expression
    /*
    for (int j = 0; j < str1dArray[i].length(); j++) {
        str2dArray[i][j] = Integer.parseInt(String.valueOf(str1dArray[i].charAt(j)));
    }
    */
    System.out.println(Arrays.toString(str2dArray[i]));
}
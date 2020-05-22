public static int[][] dupWords (String str) {

    String [] stringArray = str.split(" ");
    int countWords = 0;
    int index = 0;
    HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
    HashMap<String, Integer> countMap = new HashMap<String, Integer>();

    int index = 0;
    for (int i = 0; i < stringArray.size(); i++) {
       String s = stringArray[i];
       if (!indexMap .containsKey(s)) {
         indexMap.put(s, index);
         countMap.put(s, 1);
       }
       else {
         int cnt = countMap.get(s);
         countMap.put(s, cnt+1);
       }
       index += s.length() + 1;
    }

    int [][] retArr = new int[map.size()][2];

    for (int i = 0; i < stringArray.size(); i++) {
       String s = stringArray[i];
       retArr[i][0] = indexMap.get(s);
       retArr[i][1] = countMap.get(s);
    }

    return retArr;
}
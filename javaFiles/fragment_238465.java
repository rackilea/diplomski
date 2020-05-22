public static int[][] dupWords (String str) {

    String [] stringArray = str.split(" ");
    int countWords = 0;
    int index = 0;

    int [][] retArr = new int[stringArray.size()][2];

    int uniqeWords = 0;
    for (int i = 0; i < stringArray.size(); i++) {
       String s = stringArray[i];
       if (s != null) {
         retArr[uniqueWords][0] = str.indexOf(s);
         int cnt = 1;
         for (int j = i + 1; j < stringArray.size(); j++) {
           if (s.equalsIgnoreCase(stringArray[j])) {
             stringArray[j] = null;
             cnt++;
           }
         }
         retArr[uniqueWords][1] = cnt;
         uniqueWords++;
       }
    }

    int[][] newRetArr = new int[uniqueWords][2];
    for (int i = 0; i < uniqueWords; i++) {
      newRetArr[i][0] = retArr[i][0];
      newRetArr[i][1] = retArr[i][1];
    }

    return newRetArr;
}
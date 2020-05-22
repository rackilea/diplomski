int pairsCount = 0;
for (int i = 0; i < str.length() - 2; i ++) {
   if (str.charAt(i) == str.charAt(i + 2)) {
      pairsCount ++;
   }
}
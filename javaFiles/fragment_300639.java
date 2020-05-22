int  YvowelCount=0;
for (int i=0; i < myFile.length() - 1; i++) {
  if (myFile.charAt(i) == 'y') {
        if (!VOWEL_GROUP.contains(myFile.charAt(i+1) + "")) {
                YvowelCount++;
     }
  }
}
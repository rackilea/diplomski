int  YvowelCount=0;
for (int i=1; i < myFile.length(); i++) {
  if (myFile.charAt(i) == 'y') {
        if (!VOWEL_GROUP.contains(myFile.charAt(i-1) + "") &&
                   Character.isLetter(myFile.charAt(i-1))) {
            YvowelCount++;
     }
  }
}
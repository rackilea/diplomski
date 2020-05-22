StringBuilder builder = new StringBuilder(sentence.length());
for(int i = 0; i < sentence.length(); i++) {
  if(sentence.charAt(i) >= 65 && sentence.charAt(i) <= 90){
    int x = (int)sentence.charAt(i);
    x += key;
    while(x > 90){
      x = x - 26;
    }
    builder.append(sentence.charAt(i) + (char)x));
  } else {
    builder.append(sentence.charAt(i)); 
  }
}
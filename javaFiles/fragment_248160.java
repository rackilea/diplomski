String[] parts = code.split("Start:");
parts = parts[1].split("ende");
String result = parts[0];
//special case:
//add every splitted sub string, but NOT the last one
for (int i = 1;i<parts.length-1;i++){
  result+=parts[i];
}
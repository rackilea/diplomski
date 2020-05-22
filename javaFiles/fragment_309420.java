int no7 = 0, no0_3 = 0, no5_6 = 0;
for (int i = 0; i < myString.length(); i++) {
  char c = myString.charAt(i);
  if (c == '7') no7++;
  if (c >= '0' && c <= '3') no0_3++;
  if (c == '5' || c == '6') no5_6++;
}
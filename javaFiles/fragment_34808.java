public static boolean validSize(long cc_num) {
  int count = 0;
  if (cc_num < 0)  cc_num *= -1; // fix negative number

  while (cc_num > 0) {
    count++;
    cc_num = cc_num / 10;
  }

  //checks if length of long is correct
  return count == 15 || count == 16;
}
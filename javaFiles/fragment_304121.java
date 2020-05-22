public static void main(String[] args) {
  test("aaa", "aa");
  test("aaa", "aaa");
}

private static void test(String input, String key) {
  String encrypted = encrypt(input, key);
  String decrypted = decrypt(encrypted, key);
  if (decrypted.equals(input)) {
    System.out.print("ok: ");
  } else {
    System.out.print("error: ");
  }
  System.out.println(input + " (key=" + key + ") => " + encrypted + " => " + decrypted);
}

public static String encrypt(String input, String key) {
  String result = "";
  for (int i = 0; i < input.length(); i++) {
    int c = (int) input.charAt(i);
    //loop for all items in key
    for (int a = 0; a < key.length(); a++) {
      //adding ascii of each key value to ascii of text character
      c += (int) key.charAt(a);
      //adding I to make sure all letters dont appear the same
      c += i;
      //make sure ascii's stay between target values (excluding null)
      while (c > 126) {
        c -= 125;
      }
    }
    //converting ascii back to char and adding to result
    result += (char) c;
  }
  return result;
}

public static String decrypt(String input, String key) {
  String result = "";
  for (int i = 0; i < input.length(); i++) {
    int c = (int) input.charAt(i);
    for (int a = 0; a < key.length(); a++) {
      c -= (int) key.charAt(a);
      c -= i;
      while (c < 1) {
        c += 125;
      }
    }
    result += (char) c;
  }
  return result;
}
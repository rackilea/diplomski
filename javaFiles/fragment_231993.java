String textFromEditText= "zxbc";
String wordFromFile="cxbz";
char a[] = textFromEditText.toCharArray();
char c[] = wordFromFile.toCharArray();
Arrays.sort(a);
Arrays.sort(c);
System.out.println(String.valueOf(a).equalsIgnoreCase(String.valueOf(c)));
char[] chars1 = string1.toCharArray();
char[] chars2 = string2.toCharArray();
Arrays.sort(chars1);
Arrays.sort(chars2);

return Arrays.equals(chars1, chars2);
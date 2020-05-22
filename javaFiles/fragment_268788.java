String str = ...

char[] chars = str.toCharArray();
for(int i = 0; i < chars.length/2; i++) {
    char ch = chars[i];
    chars[i] = chars[chars.length - i - 1];
    chars[chars.length - i - 1] = ch;
}
System.out.println(new String(chars));
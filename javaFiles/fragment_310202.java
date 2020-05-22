String s = "abcd";
StringBuilder sb = new StringBuilder();
for (char c : s.toCharArray()) {
    sb.append((char)(c - 'a' + 1));
}
// provided your string contains only lower case non-unicode (ASCII) characters.
String s = "[a+b+c1 &$&$/[]]+(1+b&+c&)";
int d=0;
StringBuilder sb = new StringBuilder();
for (char ch: s.toCharArray()) {
    if (ch == ']')
        d--;
    if (d==0 || Character.isAlphabetic(ch) || Character.isDigit(ch))
        sb.append(ch);
    if (ch == '[')
        d++;
}
System.out.println(sb);
//=> [abc1]+(1+b&+c&)
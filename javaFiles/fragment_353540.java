Patter token = Pattern.compile("[() ]|a+|.", Pattern.DOT_ALL);
Matcher m = token.matcher(sourceCode);
int parenDepth = 0;
while (m.find()) {
  char ch = m.group().charAt(0);
  switch (ch) {
    case '(':
      ++parenDepth;
      break;
    case ')':
      if (parenDepth == 0) {
        fail("Too many close parens");
      }
      --parenDepth;
      break;
  }
}
if (parenDepth != 0) {
  fail(parenDepth + " unclosed lists");
}
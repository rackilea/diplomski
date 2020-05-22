String s = "I want to truncate this";
int chars = 10;
BreakIterator b = BreakIterator.getWordInstance();
b.setText(s);
int cutAt = bi.following(chars);
System.out.println(s.substring(0,cutAt))
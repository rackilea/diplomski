Pattern p = Pattern.compile("[\\x{0410}-\\x{042F}\\x{0430}-\\x{044F}]", 
                            Pattern.CANON_EQ);
Matcher m = p.matcher(string);
int count = 0;
while (m.find())
    count++;
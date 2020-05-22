String str = "0101010101110";
char[] cs = str.toCharArray();
for (int i = 0; i < cs.length; i++)
{
    if (cs[i] == '1')
        cs[i] = '0';
    else if (cs[i] == '0')
        cs[i] = '1';
}
str = new String(cs);
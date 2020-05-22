StringBuilder sb = new StringBuilder();
for (int i = 0; i < foo.length; ++i)
{
    sb.append(bar(foo[i]));
}
String result = sb.toString();
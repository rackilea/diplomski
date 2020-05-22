StringBuilder sb = new StringBuilder();
Formatter f = new Formatter(sb);

for (...)
{
    f.format("%d %d\n", 1, 2);
    myMethod(sb.toString());
    sb.setLength(0);
}
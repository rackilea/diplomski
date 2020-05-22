final StringBuilder buff = new StringBuilder();
for (char c : string.toCharArray())
{
  if (c >= 0x20 && c <= 0x7E)
  {
    buff.append(c);
  }
}

final FileWriter w = new FileWriter(...);
w.write(buff.toString());
w.close();
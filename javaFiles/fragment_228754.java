String str = /* your original string from the array */;
StringBuilder sb = new StringBuilder();
boolean skip = true;

for (int i = 0; i < str.length(); i++) {
  char ch = str.charAt(i);

  if (skip && Character.isWhitespace(ch))
    continue;

  sb.append(ch);

  if (ch == ',')
    skip = true;
  else
    skip = false;
}

String result = sb.toString();
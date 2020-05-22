int i = 0;
StringBuilder builder = new StringBuilder();
for (String value : values) {
  if (i != 0) {
    builder.append(",");
  }
  builder.append(value);
  i++;
}
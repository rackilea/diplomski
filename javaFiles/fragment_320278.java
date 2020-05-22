boolean first = true;
StringBuilder builder = new StringBuilder();
for (String value : values) {
  if (first) {
    first = false;
  } else {
    builder.append(",");
  }
  builder.append(value);
}
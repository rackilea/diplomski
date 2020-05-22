StringBuilder sb = new StringBuilder();
sb.append("INSERT INTO ")
for (String s: Rows) {
  sb.Append(s).append(", ");
}
// and so on.
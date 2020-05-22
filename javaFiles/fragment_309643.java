StringBuilder sb = new StringBuilder();
for (Object item : stack) {
    if (sb.length() > 0) sb.append(" ");
    sb.append(item);
}
System.out.println(sb.toString());
StringBuilder sb = new StringBuilder();
sb.append("update messagesmaster set rstamp = 1 where mid in (");
for (int i = 0;i < mlst.length; i++) {
    if (i>0) sb.append(", ");
    sb.append("'").append(mlst[i]).append("'");
}
sb.append(")");
String sql = sb.toString();
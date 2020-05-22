StringBuilder sb = new StringBuilder("data_id in (");
for (int i = 0; i < ids.size(); i++) {
  if (i > 0) {
    sb.append(',');
  }
  sb.append("#{dataList[").append(i).append("]}");
}
sb.append(')');
WHERE(sb.toString());
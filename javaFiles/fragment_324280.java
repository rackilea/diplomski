public static String getParameterToString(ServletRequest request){
  StringBuilder sb = new StringBuilder("{");
  for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()){
    sb.append(entry.getKey()).append(":");
    sb.append(Arrays.toString(entry.getValue())).append(",");
  }
  if (sb.length() > 1)
    sb.setLength(sb.length() - 1);
  return sb.append("}").toString();
}
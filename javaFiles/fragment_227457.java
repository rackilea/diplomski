public static String getCsv(List<String> list) {
    if (list == null)
        return null;
    StringBuilder buff = new StringBuilder();
    for(int i=0; i<list.size(); i++){
          String item = list[i];
          if (i!=0)
              buff.append(",");
          buff.append(item);
    }
    return buff.toString();
 }
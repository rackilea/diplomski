StringBuilder temp=new StringBuilder();

    for(Map.Entry<String,Integer> entry : treeMap.entrySet()) 
    {
      String key = entry.getKey();
      Integer value = entry.getValue();

      temp.append(key).append(" = ").append(value).append(", ");
    }

    //TODO remove the last comma

String result=temp.toString();
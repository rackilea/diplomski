if(gbrsubStatus.equals("N")){
      List<String> values = kppSubitleMap.get(kppKey);
      if (values = null){
          values = new ArrayList<String>();
      }
      values.add("NO GBR SUBTITLES");
      kppSubitleMap.put(kppKey, values);
     ...
  }
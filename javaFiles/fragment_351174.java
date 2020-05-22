List<Map<String,String>> options = new ArrayList<Map<String,String>>();

   String[] levels = {"zero", "one", "two"};
   for(int indx = 0; indx <levels.length; indx++){
      Map<String, String> option = new HashMap<String, String>();
      option.put("value", String.valueOf(indx));
      option.put("level", levels[indx]);
      options.add(option);
   }
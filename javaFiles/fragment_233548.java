String jsonString = writer.toString();
        JSONObject jsonObj = new JSONObject(jsonString); 
         currenciesTypes = jsonObj.get(CurrenciesKey);
        ArrayList<String> keys=new ArrayList<String>();
        ArrayList<String> values=new ArrayList<String>();
        Iterator<String> iterator=currencyType.keys();
        while(iterator.hasNext())
        {
              String key=iterator.next();
              keys.add(key);
              values.add(currencyType.get(key));
        }
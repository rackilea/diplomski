List<Float> priceList = new ArrayList<Float>();
     while ((inputLine = in.readLine()) != null){
         System.out.println(inputLine);
         String usd = inputline.substring(inputline.indexOf("USD")+25,inputline.length);     
         Float f = Float.valueOf(usd);
         priceList.add(f);              
        }
      in.close();

return priceList;
// ArrayList<String> amountList=new ArrayList<String>();
  String amount=null;
 try {
            // Getting JSON Array
            String your_json_response;
            JSONArray responseArray = new JSONArray(your_json_response);
            for(int j=0;j<responseArray.length();j++)
            {
                JSONArray spritPrice=responseArray.getJSONObject(i).JSONArray("spritPrice");

                int spritPrice= spritPrice.length();

                for(int i=0; i < spritPrice; i++ ){

                  JSONObject c = spritPrice.getJSONObject(i);

                     amount = c.getString("amount");
                     // amountList.add(amount); 
                      System.out.println(amount);
                       if(amount!=null)
                          break;
                    }
                    if(amount!=null)
                      break;
                }
            } catch (JSONException e) {
            e.printStackTrace();
            }
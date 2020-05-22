try {
        JSONObject jsonObject = new JSONObject(yourJsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("result"); 
        for(int i=0;i<jsonArray.length();i++){
            LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
            JSONObject innerJosonObject = new JSONObject(jsonArray.getString(i));

            // you need to put all values from jsonObject to map for managing the order.. 

            linkedHashMap.put("doc_no","Custom Value");
            linkedHashMap.put("itembarcode",innerJosonObject.getString("itembarcode"));
            linkedHashMap.put("weight",innerJosonObject.getString("weight"));
            linkedHashMap.put("gross_wt", innerJosonObject.getString("gross_wt"));
            //..................... rest of others......
            linkedHashMap.put("sum_total",innerJosonObject.getString("sum_total"));
            Gson gson = new Gson();
            // convert linkedHashMap to json string and it will keep the insertion order..
            String string = gson.toJson(linkedHashMap,LinkedHashMap.class);
            jsonArray.put(i,string);
        }
        jsonObject.put("result",jsonArray);
        Log.e("json",jsonObject.toString());
       // this prints jsonArray only [............]
        Log.e("json_array", jsonArray.toString());


    }catch (Exception e){

    }




 Output:`{"result":["{\"doc_no\":\"Custom Value\",\"itembarcode\":\"BRMS\",\"weight\":\"10\",\"gross_wt\":\"1\",\"sum_total\":\"64600.0\"}",
                    "{\"doc_no\":\"Custom Value\",\"itembarcode\":\"MSAA0015\",\"weight\":\"10\",\"gross_wt\":\"11\",\"sum_total\":\"64600.0\"}"]}`
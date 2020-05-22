JSONObject obj = new JSONObject(additionalThirdParty);


        JSONObject objtobeadded =  new JSONObject();
        objtobeadded.put("thirdPartyId", "TH11");
        objtobeadded.put("Location", "Belgium");
        objtobeadded.put("addtionalInfo", new JSONArray());

        JSONObject assetsObj = obj.getJSONObject("object").getJSONObject("ASSETS");

        JSONArray prodDetailsArr = assetsObj.getJSONArray("productDetails");

        for(int i=0;i<prodDetailsArr.length();i++){            
            JSONArray arr = prodDetailsArr.getJSONObject(i).getJSONArray("productThirdPartyDetails");
            arr.put(objtobeadded);
        }
        System.out.println(obj.toString());
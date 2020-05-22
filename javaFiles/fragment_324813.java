JSONObject arrObj = (JSONObject) arr;
  if(arrObj.has("text")) {
    JSONObject text = (JSONObject) arrObj.get("text");
    JSONObject par = (JSONObject) text.get("par");
    JSONObject line = (JSONObject) par.get("line");
    JSONObject formatting = (JSONObject) line.get("formatting");
    JSONArray charParamsArray = (JSONArray) formatting.get("charParams");

    charParamsArray.forEach(
      charParamObj -> {
        JSONObject charParam = (JSONObject) charParamObj;
       if (charParam.has("content")) {                                       
           System.out.print(charParam.get("content"));
        } else {
            System.out.print(" ");
        }
      });
    System.out.println("");
  }
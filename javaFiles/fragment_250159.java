ArrayList<PromesaPago> result = new ArrayList<>();
    JSONObject object=new JSONObject(json);
                JSONArray dataArray=object.getJSONArray("promesas");
                for(int n = 0; n < dataArray.length(); n++)
                {
                    JSONObject object = dataArray.getJSONObject(n);
                    result.add(gson.fromJson(object.toString(), PromesaPago.class));
                }
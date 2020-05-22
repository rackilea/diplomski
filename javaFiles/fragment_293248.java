JSONArray objects=new JSONObject(jsondata).getJSONArray("objects");  
    for(int i=0;i<objects.length();i++){  
        JSONObject object=objects.getJSONObject(i);  
        System.out.println("value of left=="+object.getString("left"));  
        System.out.println("value of top=="+object.getString("top"));  

    }
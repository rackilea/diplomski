for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        CarClass car = new CarClass();
                    .....
        carClassList.add(car);  // remove the comment
     } 
       adapter = new CarAdapter(getApplicationContext(), carClassList);
       mList.setAdapter(adapter);
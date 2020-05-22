spinnerCategory.setOnItemSelectedListener(new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View arg1,
                int pos, long arg3) {
            // TODO Auto-generated method stub
            Toast.makeText(parent.getContext(), "On Item Select : \n" + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();

            strSelected_Category=parent.getItemAtPosition(pos).toString();
            System.out.println("strSelected_Category  = " + strSelected_Category);
            spinnerSubCategory.setEnabled(true);

            ServiceHandler jsonParser = new ServiceHandler();
            String json = jsonParser.makeServiceCall(URL_SUB_CATEGORIES, ServiceHandler.GET);

            Log.e("Response: ", " > " + json);
            if (json != null)
            {
                try {
                    JSONArray array=new JSONArray(json);

                    JSONArray sortedArray = new JSONArray();
                    for(int i=0;i<array.length();i++)
                    {
                        JSONObject obj=array.getJSONObject(i);
                        if(obj.getString("cat_name").equalsIgnoreCase(strSelected_Category))
                        {
                            sortedArray.put(obj);
                            Log.e("sortedArray"," = " +sortedArray);
                        }
                    }
                    sub_categoriesList.clear();
                    if (sortedArray != null)
                    {
                        for (int i = 0; i < sortedArray.length(); i++)
                        {
                            JSONObject catObj = (JSONObject) sortedArray.get(i);
                            Category cat = new Category(catObj.getInt("subcat_id"),catObj.getString("subcat_name"));
                            sub_categoriesList.add(cat);

                            Log.e("cat "," = " + cat);
                        }
                        populateSubCategory();
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } 
            else 
            {
                Log.e("JSON Data", "Didn't receive any data from server!");
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }
    });
}

/**
 * Adding Category spinner data
 * */
private void populateSpinner() {
    List<String> lables = new ArrayList<String>();

    for (int i = 0; i < categoriesList.size(); i++)
    {
        lables.add(categoriesList.get(i).getName());
    }
    ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, lables);
    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinnerCategory.setAdapter(spinnerAdapter);
}

private void populateSubCategory() {
    List<String> lables = new ArrayList<String>();

    for (int i = 0; i < sub_categoriesList.size(); i++)
    {
        lables.add(sub_categoriesList.get(i).getName());
    }
    ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, lables);
    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinnerSubCategory.setAdapter(spinnerAdapter);
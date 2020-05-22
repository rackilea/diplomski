try {

                JSONArray jArray = response.getJSONArray("data");

                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json_data = jArray.getJSONObject(i);

                    Pojo dataPojo = new Pojo(); //this is catagory class
                    dataPojo.setCatagory_id(json_data.getString("category_id"));
                    dataPojo.setCatagory_name(json_data.getString("category_name"));
                    dataPojo.setCatagory_thumbnailUrl(json_data.getString("category_image"));


                    JSONArray jArray1 = json_data.getJSONArray("subcategory");

                    ArrayList<SubCatagory> subCatagoryArrayList = new ArrayList<>();
                    for (int j = 0; j < jArray1.length(); j++) {
                        JSONObject json_data1 = jArray1.getJSONObject(j);

                        SubCatagory subCatagory = new SubCatagory(); // this is subcatagory class
                        subCatagory.setSubcatagory_id(json_data1.getString("category_id"));
                        subCatagory.setSubcatagory_name(json_data1.getString("category_name"));
                        subCatagoryArrayList.add(subCatagory);
                    }
                    dataPojo.setSubCatagoryArrayList(subCatagoryArrayList);//this i insert subcatagory in catagory 
                    dataList.add(dataPojo); // and after i add catagory to datalist 
                }

              /*  dataAdapter = new DataAdapter(dataList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(dataAdapter);
                dataAdapter.notifyDataSetChanged();*/
  }
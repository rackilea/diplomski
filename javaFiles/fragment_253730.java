final ListView category_listview = (ListView)findViewById(R.id.category_dashboard_list);

 try {
            jsono = new JSONObject(jsonvalue);
            jarray = jsono.getJSONArray("jsonvalue");
            for (int i = 0; i < jarray.length(); i++) {
                JSONObject object = jarray.getJSONObject(i);
                try
                {
                   // object = jarray.getJSONObject(i);
                    Category_Detail_Model category_obj = new Category_Detail_Model();
                    category_obj.setCategory_Title(object.getString("bookmark_title"));
                    category_obj.setCategory_Description(object.getString("bookmark_title"));
                    category_obj.setCategory_Url(object.getString("bookmark_website"));
                    category_obj.setImage(object.getString("bookmark_preview_image"));
                    cate_list.add(category_obj);
                    category_detail = new Category_Dashboard_Adapter(getApplicationContext(), R.layout.category_row_list, cate_list);
                    category_listview.setAdapter(category_detail);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
for(int i = 0; i < response.length(); i++){
                //SliderUtils sliderUtils = new SliderUtils();
                Model_Data DataModelFile = new Model_Data();
                try {
                    JSONObject jsonObject = response.getJSONObject(i);
                    DataModelFile.setModelId(jsonObject.getString("id"));
                    DataModelFile.setModelName(jsonObject.getString("name"));
                    DataModelFile.setModelPrice(jsonObject.getString("price"));
                    DataModelFile.setBikeImageUrl(jsonObject.getString("image"));
                    if ((Integer.parseInt(jsonObject.getString("available")) > 0) && (Integer.parseInt(jsonObject.getString("show")) > 0)) {
                        DataModelFile.setBikeAvailable(true);
                    }
                    else
                    {
                        DataModelFile.setBikeAvailable(false);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ModelDataForView.add(DataModelFile);
            }
adapter.notifyDataSetChanged();
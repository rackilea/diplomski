for(int i = 0; i < list.length();i++){
                JSONObject elem = list.getJSONObject(i);
                if(elem != null){
                    JSONObject prods = elem.getJSONObject("resource")
                                           .getJSONObject("fields");

                    Object level = prods.get("type");
                    Toast.makeText(getApplicationContext(),""+level.toString(),Toast.LENGTH_LONG).show();
                }
            }
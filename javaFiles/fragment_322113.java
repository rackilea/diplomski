try {
                JSONArray jsonArray=new JSONArray();
                JSONObject object1=new JSONObject();
                object1.put("url","myurl");
                object1.put("phone","myphonenumber");
                object1.put("country","mycountry");

                //saving a list of another object contaning firstname and lastname
                JSONArray listArray=new JSONArray();

                //supposing your list contains 10 objects
                for(int f=0;f<10;f++){
                    JSONObject listobject=new JSONObject();
                    listobject.put("firstname","myfirstname");
                    listobject.put("lastname","mylastname");
                    listArray.put(listobject);
                }
                //now the list array we added as an object of the jsonArray variable
                JSONObject object2=new JSONObject(); //object2 containing the list of firstname and lastname
                object2.put("list",listArray.toString());
                jsonArray.put(object1);//object1 contains the url, phone, and country
                jsonArray.put(object2);//object2 contains the list of firstname and lastname


            } catch (JSONException e) {
                e.printStackTrace();
            }
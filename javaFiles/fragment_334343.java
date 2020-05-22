HashMap<String,String> paramage= new HashMap<String, String>();

Kumulos.call("login", params, new ResponseHandler() {
            @Override
            public void didCompleteWithResult(Object result) {

                Integer field2 = 0;
                ArrayList<LinkedHashMap<String, Object>> objects = (ArrayList<LinkedHashMap<String, Object>>) result;
                LinkedHashMap<String, Object> item = objects.get(0);
                field2 = Integer.parseInt(item.get("credentialID").toString());
                ID = field2.intValue();
                UName.setText(Integer.toString(ID));

                paramage.put("credential", Integer.toString(ID));     //up here

                //As you are making web service call for "getage" so I put this code here. You can make a callback to write this code outside for "getage" webservice call.
                Kumulos.call("getage", paramage, new ResponseHandler() {
                    @Override
                    public void didCompleteWithResult(Object result) {
                        Integer field2 = 0;
                        ArrayList<LinkedHashMap<String, Object>> objects = (ArrayList<LinkedHashMap<String, Object>>) result;
                        LinkedHashMap<String, Object> item = objects.get(0);
                        //Boolean check = item.containsKey("age");
                        field2 = Integer.parseInt(item.get("age").toString());
                        int age = field2.intValue();
                        UAge.setText(Integer.toString(age));
                    }
                });
            }
        });
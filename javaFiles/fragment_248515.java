ArrayList<String> result = task.execute(itensUrl).get();
        for(int i = 0 ; i < result.size() ; i++) {
            String currentList = result.get(i);
            JSONObject jsonobject = new JSONObject(currentList);

            String id=jsonobject.optString("id");
            String value1=jsonobject.optString("name_user_feed");
            String value2=jsonobject.optString("establishment");
            System.out.println("id="+id);
            System.out.println("value1="+value1);
            System.out.println("value2=" +value2);

        }
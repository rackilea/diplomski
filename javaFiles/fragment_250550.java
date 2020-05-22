public void getRepJSONdata(){
        try{
            JSONArray allRepsResults = allRepData.getJSONArray("objects");
            for (int i = 0; i < allRepsResults.length(); i++) {
                JSONObject currentItem = allRepsResults.getJSONObject(i);
                JSONObject person = currentItem.getJSONObject("person");
                String firstName = person.getString("firstName");
                String lastName = person.getString("lastName");

            }
        }catch (Exception ex){
            //trace out bad stuff
        }
    }
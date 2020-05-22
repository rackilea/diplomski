try {
        //String jsonString="{\"notes\": {\"note\": [{\"content\": \"Having wisdom teeth removed.\",\"from\": \"employee\" }, {\"content\": \"Get well soon\", \"from\": \"manager\"} ] }}";
        //String jsonString="{\"notes\": { \"note\": {\"content\": \"This is a test note.\",\"from\": \"employee\"}}}";
        String jsonString="{\"notes\": { \"note\": \"\"}}";

        JSONObject jsonObject=new JSONObject(jsonString);
        JSONObject jsonObjectNotes=jsonObject.getJSONObject("notes");

        try{
            JSONArray jsonArrayNote=jsonObjectNotes.getJSONArray("note");
            for (int i = 0; i < jsonArrayNote.length(); i++) {

                JSONObject jsonObject2= jsonArrayNote.getJSONObject(i);
                String stringContent=jsonObject2.getString( "content");
                String stringFrom= jsonObject2.getString( "from");

                Log.e(getClass().getName(), "content="+stringContent +"; from="+stringFrom);
            }
        }
        catch(JSONException e){
            //that means that jsonObjectNotes has no jsonArray with name "notes" and "notes" is jsonObject
            try{
                JSONObject jsonObject3=jsonObjectNotes.getJSONObject("note");

                String stringContent=(String) jsonObject3.get( "content");
                String stringFrom=(String) jsonObject3.get( "from");

                Log.e(getClass().getName(), "content="+stringContent +"; from="+stringFrom);
            }
            catch(JSONException ex){
                //that means that jsonObjectNotes has no jsonObject with name "notes" and "notes" is empty String
                String stringNote=jsonObjectNotes.getString("note") ;       
                Log.e(getClass().getName(), "note is string ="+ stringNote);
            }
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }
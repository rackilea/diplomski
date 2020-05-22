@Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        //conver result into json object
        try{
            JSONObject jsonObject=new JSONObject(result);

            //get current JSONObject from result JSONObject
            JSONObject currentJSONObject = jsonObject.getJSONObject("current");

            //Now get condition JSONObject from current JSONObject
            JSONObject conditionJSONObject = currentJSONObject.getJSONObject("condition");

            //Now print condition JSONObject
            Log.i("website content", "condition json object : " + conditionJSONObject.toString());

        } catch (Exception e){

        }

    }
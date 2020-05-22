@Override
protected void onPostExecute(String s) {
    super.onPostExecute(s);
    Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();
    try{
        JSONObject json = new JSONObject(s);
        if(json.getBoolean("success")){
            objadapter.removeItem(po)
        }else{
            Toast.makeText(getActivity(), 
            json.getString("message"), 
            Toast.LENGTH_LONG).show();
        }       
    }catch(JSONException ex){

    }
}
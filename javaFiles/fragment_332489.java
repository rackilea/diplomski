@Override
public void onResponse(String response) {
    Log.d("from onResponse()", response);
    response = response.trim();
    if(response.equals("no_such_table")){
        //do something
    }else{
        //do something else
    }
}
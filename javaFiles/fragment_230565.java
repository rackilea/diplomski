int statusCode = connection.getResponseCode();
if(statusCode==200){
Log.d("Connection Status","Can connect");
}
else{
Log.d("Connection Status","Can't connect");
}
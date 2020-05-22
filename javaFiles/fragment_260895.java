if(str.toString().equalsIgnoreCase("true"))
{
    Log.w("SENCIDE", "TRUE");
    publishProgress("Login Successful! Please Wait...");   
}else
{
    Log.w("SENCIDE", "FALSE");
    publishProgress(str);                
}
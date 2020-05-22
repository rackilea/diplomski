urlConnection.connect();
InputStream inputStream = null;
if(urlConnection.getResponseCode() == 200) {
    inputStream = urlConnection.getInputStream();
}else
{
    inputStream =  urlConnection.getErrorStream()
}
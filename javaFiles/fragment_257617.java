public class MessagePassing<T>
{
public void GetFrom(String url)
{
    new Connection().execute(url);
}
private class Connection extends AsyncTask<String , Void , T>
{
    @Override
    protected T doInBackground(String... params)
    {
        String strurl = params[0];
        HttpHeaders requestHeaders = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity(null, requestHeaders);
        RestTemplate restTemplate = new RestTemplate();
        T result = null;
        try {
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            ResponseEntity rssResponse = restTemplate.exchange(
                    strurl,
                    HttpMethod.GET,
                    requestEntity,
                    Message.class);
            result = (T) rssResponse.getBody();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return result;

}

    @Override
    protected void onPostExecute(T result) {
        MessageListener<T> messageMessageListener = new MessageListener<>();
        messageMessageListener.OnDataReceived(result);
    }
}
}
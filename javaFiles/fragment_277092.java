SocketIOClient.initInstance(your parameters, new ResponseHandler(this)
{
    //ResponseHandler have an abstract method called execute(). So you are overriding it here
    @Override
    public void execute(JSONObject jsonObject) throws JSONException
    {
        // Here you will get your JSONObject passed from socket class
    }
}
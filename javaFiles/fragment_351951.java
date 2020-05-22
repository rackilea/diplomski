class CheckConnection extends TimerTask {
    private Context context;
    public CheckConnection(Context context){
        this.context = context;
    }
    public void run() {
        if(NetworkUtils.isNetworkAvailable(context)){
            //CONNECTED
        }else {
            //DISCONNECTED
        } 
    }
}
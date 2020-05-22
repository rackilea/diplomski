public boolean isConnected(){
        boolean status=false;
        ConnectivityManager cManager=(ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo[] allNetworkInfo = cManager.getAllNetworkInfo();
        for (int i = 0; i<allNetworkInfo.length; i++){
            if (allNetworkInfo[i].isConnectedOrConnecting()){
                status = true;
            }
        }
        return  status;
    }
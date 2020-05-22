public static ShareData getInstance(){
    if(sdInstance == null){
        sdInstance = new ShareData();
    }
    return sdInstance;
}
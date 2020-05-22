public Socket getmSocket(){
    if(mSoket == null)
        createSoket();

    return mSocket;
}
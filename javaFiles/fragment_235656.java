public Handler uiHandler = new Handler() {
    public void handleMessage(Message inputMessage) {
        Log.d("FROM UI THREAD",inputMessage.obj.toString());
        if(loop) {
            Message msg = workerThreadHandler.obtainMessage();
            String url = "http://192.168.1.224:9000/xml/android_reply";
            msg.obj = url;
            workerThreadHandler.sendMessageDelayed(msg,1000);
        }
    }
};
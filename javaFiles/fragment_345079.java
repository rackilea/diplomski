public void onDataReceived(int id, byte[] data) {

        dataReceived = new String(data);
        ((MyBAIsWrapper) bis).renew(data);

        runOnUiThread(new Runnable(){
            @Override
            public void run() { 
                mSession.write(dataReceived);       
            }});

        viewHandler.post(updateView);
    }
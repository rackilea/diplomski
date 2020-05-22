mHandler.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "Call the Activity");

                Intent intent = new Intent(YourActivity.CALL_FROM_PLUGIN);
                intent.putExtra("request", <<Any extras you might want to send through>>);
                sendBroadcast(intent);
            }
        });
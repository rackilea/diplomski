Handler mainHandler = new Handler(mCtx.getMainLooper());
mainHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.callbackCall();
            }
        });
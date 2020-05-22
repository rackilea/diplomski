// Handler of incoming messages from clients.

    private static class IncomingHandler extends Handler {
        private WeakReference<YourActivity> yourActivityWeakReference;

        public IncomingHandler(YourActivity yourActivity) {
            yourActivityWeakReference = new WeakReference<>(yourActivity);
        }

        @Override
        public void handleMessage(Message message) {
            if (yourActivityWeakReference != null) {
                YourActivity yourActivity = yourActivityWeakReference.get();

Edited :          new ProgressTask().execute(); 
//                switch (message.what) {
//                }
            }
        }
    }
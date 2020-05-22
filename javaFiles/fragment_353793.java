/* Handle any command sent by the app here */
    command_broadcast_receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("COS", "CALLED?");
            try {
                String command = intent.getStringExtra("command");

                /* Based on the command given, perform an action */
                switch (command) {
                    case "RESTART RECOGNIZER":
                        break;
                    case "STOP":
                        Toast.makeText(context, "Phrase Listener Stopped", Toast.LENGTH_SHORT).show();
                        stopSelf();
                        break;
                }
            }
            catch (Exception e){}
        }
    };
LocalBroadcastManager.getInstance(this).registerReceiver(command_broadcast_receiver, new IntentFilter(PHRASE_SERVICE_BROADCAST_ID));
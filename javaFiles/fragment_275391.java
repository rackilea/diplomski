/*
         * this activity will be started if the user touches a notification that we own. 
         * We send it's data off to the push plugin for processing.
         * If needed, we boot up the main activity to kickstart the application. 
         * @see android.app.Activity#onCreate(android.os.Bundle)
         */
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            Log.v(TAG, "onCreate");

            boolean isPushPluginActive = PushPlugin.isActive();
            processPushBundle(isPushPluginActive);

            finish();
            GCMIntentService.hmap.clear();
            if (!isPushPluginActive) {
                forceMainActivityReload();
            }
        }
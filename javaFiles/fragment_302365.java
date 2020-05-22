public class SomeActivity extends Activity{

        private ClientService clientService;
        private ServiceConnection clientConnection = new ServiceConnection() {

            public void onServiceDisconnected(ComponentName name) {
                mBound = false;
            }

            public void onServiceConnected(ComponentName name, IBinder service) {
                ClientService.ClientBinder binder = (ClientService.ClientBinder) service;
                clientService = binder.getService();
                mBound = true;
                if (facebook != null)
                    if (facebook.isSessionValid())
                        clientService.setFacebook(facebook);
            }
        };

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, ClientService.class);
        bindService(intent, clientConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(clientConnection);
            mBound = false;
        }

    }


.................

    //And HERE IS MAGIC
    .....
    private void logINFacebook() {
            if (facebook.isSessionValid())
                return;

            facebook.authorize(this,
                    getResources().getStringArray(R.array.facebookPermissions),
                    new DialogListener() {
                        public void onFacebookError(FacebookError e) {...}

                        public void onError(DialogError e) {...}

                        public void onComplete(Bundle values) {
                            if (mBound) {
                                clientService.setFacebook(facebook);
                            }

                            //Save to shared preferences(optional)
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString(FACEBOOK_TOKEN_PREFNAME,
                                    facebook.getAccessToken());
                            editor.putLong(FACEBOOK_EXPIRES_PREFNAME,
                                    facebook.getAccessExpires());
                            editor.commit();
                        }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        facebook.authorizeCallback(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    }
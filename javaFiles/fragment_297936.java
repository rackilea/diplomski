@Override
        protected void onServiceConnected() {
            TextView userName = (TextView) findViewById(R.id.loggedInName);
            userName.setText(getSinchServiceInterface().getUserName());
            mCallButton.setEnabled(true);  // <--- might try changing this?
        }
buttonLogin= (Button) findViewById(R.id.buttonLogin);
    buttonLogin.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("hello", "hellow");
            String username = mUserEditText.getText().toString();
            String password = mPassEditText.getText().toString();
            String location = mLocationData.get(mLocationSpinner.getSelectedItemPosition()).toLowerCase();
            if(username.isEmpty()||password.isEmpty()){
            popbox();
                return;
            }
            User user;
            user = new User(username);
            user.setLocation(location);
            AppManager.getInstance().setLoggedInUser(user);
            APICaller.getInstance().login(username, password, location);
        }
    });
    buttonLogin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            v.performClick();
        }
    }
});
}
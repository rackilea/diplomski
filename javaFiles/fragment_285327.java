public void popupInit() {
         final LayoutInflater inflater 
         = (LayoutInflater)getBaseContext()
          .getSystemService(LAYOUT_INFLATER_SERVICE); 
       final View popupView = inflater.inflate(R.layout.popup, null);

       final PopupWindow popUp = new PopupWindow(popupView,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        popUp.setFocusable(true);
        popUp.setOutsideTouchable(isRestricted());

        Button login = (Button) popupView.findViewById(R.id.loginButton);
        login.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                 popUp.setContentView(inflater.inflate(R.layout.popup, null, false));
                 final EditText  username = (EditText) popupView.findViewById(R.id.username);
                    final EditText  password = (EditText) popupView.findViewById(R.id.password);
                        String user_name =username.getText().toString();
                        String pass_word = password.getText().toString();
                        Log.i("Username,password",(user_name+"-->"+pass_word));
                        popUp.dismiss();
            }

        });
         popUp.showAtLocation(popupView, Gravity.CENTER, 0, 0);
    }
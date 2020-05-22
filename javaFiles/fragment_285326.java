@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final Button btn = (Button)findViewById(R.id.btnId);
         btn.setOnClickListener(new OnClickListener() {

             @Override
             public void onClick(View v) {

                 LayoutInflater layoutInflater 
                 = (LayoutInflater)getBaseContext()
                  .getSystemService(LAYOUT_INFLATER_SERVICE); 
                 View popupView = layoutInflater.inflate(R.layout.popup, null);  
               final View  popupView1 = layoutInflater.inflate(R.layout.popup, null);

                final PopupWindow popUp = new PopupWindow(popupView1,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
                 popUp.setFocusable(true);
                 popUp.setOutsideTouchable(isRestricted());
                 Button login = (Button) popupView1.findViewById(R.id.loginButton);
                 login.setOnClickListener(new Button.OnClickListener(){

         @Override
         public void onClick(View v) {
             popUp.setContentView(popupView1);


         final EditText  username = (EditText) popupView1.findViewById(R.id.username);
         final EditText  password = (EditText) popupView1.findViewById(R.id.password);
             String user_name =username.getText().toString();
             String pass_word = password.getText().toString();
         Log.i("info",(user_name+pass_word));
          popUp.dismiss();
         }});

                 popUp.showAsDropDown(btn, 50, -30);
                 }


         });

    }
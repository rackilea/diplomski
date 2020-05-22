/* here you point to the id of the landscape layout */
     int mode = R.layout.graphing; 

     @Override

     protected void onCreate(Bundle bundle) {

          super.onCreate(bundle);

          if ((bundle != null)

                  && (bundle.getChar('O') != null)) {
              View v=(View)findViewById(mode);
              setContentView(v);

          }

       }
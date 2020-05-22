public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        public void sendMessage(View view) {   
            runOnUiThread(new Runnable() {
               @Override
               public void run()
               {
                  Toast.makeText(getBaseContext(), "Your answer is correct!" , Toast.LENGTH_SHORT ).show();
               }
            });
        }

    }
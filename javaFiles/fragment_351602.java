public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = "test@test.com"; // blah, blah .getText()
                String password = "password"; // blah, blah .getText()

                new LoginTask().execute("type?", email, password);
            }
        });
    }

    class LoginTask extends AsyncTask<String, Void, Boolean> {

        private String email;

        @Override
        protected Boolean doInBackground(String... params) {
            String type = params[0];
            this.email = params[1]; // save the email, if you want
            String password = params[2];

            // Do your database stuff
            try {
                // Simulate some long running operation
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

            Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();

            if (result) {
                Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                i.putExtra("email", this.email); // send some arguments to the next activity
                startActivity(i); // You have logged-in, move to the next screen
                finish(); // Kill the login activity
            } 
        }
    }
}
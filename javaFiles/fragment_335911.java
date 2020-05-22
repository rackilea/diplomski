public class OnClickListenerLogin implements OnClickListener {

        private EditText txtUsername;
        private EditText txtPassword; 

        public OnClickListenerLogin (EditText userEditText, EditText passwordEditText) {
            this.txtUsername = userEditText;
            this.txtPassword = passwordEditText;
        }

       @Override
       public void onClick(View view) {
             String username = txtUsername.getText().toString();
             String password = txtPassword.getText().toString();

             Log.d("test", username + "-" + password);
       }
 }
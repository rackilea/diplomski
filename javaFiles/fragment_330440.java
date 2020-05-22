import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {

    TextView signup;
    String email,password;
    EditText log_username,log_password;
    Button login_button;
    DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        signup = (TextView)findViewById(R.id.signup);
        String htmlString="<u>Signup</u>";
        signup.setText(Html.fromHtml(htmlString));
        log_username = (EditText)findViewById(R.id.log_username);
        log_password = (EditText)findViewById(R.id.log_password);
        login_button = (Button)findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=new DatabaseHandler(Login_Activity.this, null, null, 2);
                email = log_username.getText().toString();
                password = log_password.getText().toString();
                String StoredPassword =db.getregister(email);
                if(password.equals(StoredPassword)){

                    Toast.makeText(getApplicationContext(),"Login Successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login_Activity.this,VideoActivity.class);
                    startActivity(intent);
                    Login_Activity.this.finish();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Username/Password incorrect", Toast.LENGTH_LONG).show();
                    log_username.setText("");
                    log_password.setText("");
                }



            }
        });




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this,Registration_Activity.class);
                startActivity(intent);
                Login_Activity.this.finish();
            }
        });

    }
}
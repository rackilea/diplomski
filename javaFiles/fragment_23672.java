import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LinkActivity extends Activity {

    EditText txtLink;
    Button btnOpenLink;
    String defaultLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        defaultLink = "http://www.google.com";

        txtLink = (EditText) findViewById(R.id.editTextLink);
        btnOpenLink = (Button) findViewById(R.id.buttonOpenLink);
        btnOpenLink.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String page = txtLink.getText().toString();
                if(!TextUtils.isEmpty(page)){
                    Uri uri = Uri.parse(defaultLink+"/"+page);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }else{
                    Toast.makeText(LinkActivity.this, "Please enter page on editText!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
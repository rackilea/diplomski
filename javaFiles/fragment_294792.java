import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.com.iisi.staffing.R;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MessageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new PostDataTask(this).execute("","testing@testing.com","Testing","Testing message");
    }

    private class PostDataTask extends AsyncTask<String, Void, Boolean> {

        public final MediaType FORM_DATA_TYPE
                = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
        //URL derived from form URL
        public static final String URL="https://docs.google.com/forms/d/e/1FAIpQLSeZp9wjprZJ3OR2SkIHHsZE9yDBAVnC7mO8hPKSzwGuYhqmdw/formResponse";
        //input element ids found from the live form page
        public static final String EMAIL_KEY="entry_943499687";
        public static final String SUBJECT_KEY="entry_2058392291";
        public static final String MESSAGE_KEY="entry_1420026128";
        private Context context;

        public PostDataTask(Context context)
        {
            this.context = context;
        }

        @Override
        protected Boolean doInBackground(String... contactData) {
            Boolean result = true;
            String url = contactData[0];
            String email = contactData[1];
            String subject = contactData[2];
            String message = contactData[3];
            String postBody="";

            try {
                //all values must be URL encoded to make sure that special characters like & | ",etc.
                //do not cause problems
                postBody = EMAIL_KEY+"=" + URLEncoder.encode(email,"UTF-8") +
                        "&" + SUBJECT_KEY + "=" + URLEncoder.encode(subject,"UTF-8") +
                        "&" + MESSAGE_KEY + "=" + URLEncoder.encode(message,"UTF-8");
            } catch (UnsupportedEncodingException ex) {
                result=false;
            }



            try{
                //Create OkHttpClient for sending request
                OkHttpClient client = new OkHttpClient();
                //Create the request body with the help of Media Type
                RequestBody body = RequestBody.create(FORM_DATA_TYPE, postBody);
                Request request = new Request.Builder()
                        .url(URL)
                        .post(body)
                        .build();
                //Send the request
                Response response = client.newCall(request).execute();
            }catch (IOException exception){
                result=false;
            }
            return result;
        }

        @Override
        protected void onPostExecute(Boolean result){
            Toast.makeText(context,result?"Message successfully sent!":"There was some error in sending message. Please try again after some time.",Toast.LENGTH_LONG).show();
        }

    }
}
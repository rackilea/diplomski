import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;

public class SingleContactActivity extends Activity {
    String myArticleUrl = "http://ana.fm/api/article/256281468161349/";
    TextView txtTitle;
    TextView txtDesc;
    JSONParser jParser = new JSONParser();
    JSONArray articles = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article);

        txtTitle = (TextView) findViewById(R.id.single_article_title);
        txtDesc = (TextView) findViewById(R.id.single_article_desc);

        new LoadAllArticles().execute();
    }

    // LOADING ALL ARTICLES IN THE BACKGROUND
    class LoadAllArticles extends AsyncTask<String, String, String> {

        private ProgressDialog progressDialog = new ProgressDialog(SingleContactActivity.this);
        InputStream inputStream = null;
        String result = "";
        String title = "";
        String description = "";

        protected void onPreExecute() {
            progressDialog.setMessage("Downloading articles...");
            progressDialog.show();
            progressDialog.setOnCancelListener(new     DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface arg0) {
                    LoadAllArticles.this.cancel(true);
                }
            });
        }

        @Override
        protected String doInBackground(String... params) {

        String url_select = myArticleUrl;

        ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();

        try {
            JSONObject json = jParser.makeHttpRequest(url_select,
                    "GET", param);  // Change "GET" to "POST" if you want the POST method

            articles = json.getJSONArray("article");

            JSONObject jsonObj = articles.getJSONObject(0);

            title = jsonObj.getString("title");
            description = jsonObj.getString("description");

        }
        catch (IllegalStateException e3) {
            Log.e("IllegalStateException", e3.toString());
            e3.printStackTrace();
        }
        catch (JSONException e5) {
            Log.e("JSONException", e5.toString());
            e5.printStackTrace();
        }

        return null;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                String newTitle = Html.fromHtml(title).toString();
                txtTitle.setText(newTitle);
                String newDesc = Html.fromHtml(description).toString();
                txtDesc.setText(newDesc);
                progressDialog.dismiss();
            } catch (Exception e) {
                Log.e("JSONException", "Error: " + e.toString());
            }
        }

    }
}
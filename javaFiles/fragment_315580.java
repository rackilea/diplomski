import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.AdapterView;
 import android.widget.ListView;
 import android.widget.Toast;

 import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {

private ListView listView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listView = (ListView) findViewById(R.id.listview_github_entries);

    listView.setAdapter(new GithubEntryAdapter(MainActivity.this, getList()));


    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            TextView github_url_tv = view.findViewById(R.id.github_url); 
            String url_text= github_url_tv.getText().toString();

            Toast.makeText(MainActivity.this, url_text", Toast.LENGTH_LONG).show();
        }
    });
}


private ArrayList<GithubEntry> getList() {

    ArrayList<GithubEntry> githubEntries = new ArrayList<>();

    GithubEntry githubEntry = new GithubEntry();
    githubEntry.setGithub_name("Name");
    githubEntry.setGithub_url("url");


    GithubEntry githubEntry1 = new GithubEntry();
    githubEntry1.setGithub_name("Name");
    githubEntry1.setGithub_url("url");

    GithubEntry githubEntry2 = new GithubEntry();
    githubEntry2.setGithub_name("Name");
    githubEntry2.setGithub_url("url");

    githubEntries.add(githubEntry);
    githubEntries.add(githubEntry1);
    githubEntries.add(githubEntry2);

    return githubEntries;

}
}
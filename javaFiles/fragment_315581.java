import android.app.Activity;
   import android.view.LayoutInflater;
   import android.view.View;
   import android.view.ViewGroup;
   import android.widget.ArrayAdapter;
   import android.widget.TextView;

   import java.util.ArrayList;

    public class GithubEntryAdapter extends ArrayAdapter<GithubEntry> {

    public GithubEntryAdapter(Activity context, ArrayList<GithubEntry> 
    githubEntries){
    super(context, 0, githubEntries);
}

public View getView(int position, View convertView, ViewGroup parent){
    View listItemView = convertView;
    if (listItemView == null){
        listItemView = LayoutInflater.from(getContext()).inflate(
                R.layout.list_item, parent, false);
    }

    GithubEntry currentGithubEntry = getItem(position);
    TextView github_url = (TextView) listItemView.findViewById(R.id.github_url);
    github_url.setText(currentGithubEntry.getGithub_url());
    TextView github_name = (TextView) listItemView.findViewById(R.id.github_name);
    github_name.setText(currentGithubEntry.getGithub_name());
    return listItemView;

}
}
public class ScoreList extends SherlockFragmentActivity {

private ListView listViewScore;

private ScoreListAdapter adapter;

static List<Score> listScore = new ArrayList<Score>();
@Override
public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.score_list);
    ctx = this;
    listScore = dbh.getAllScores();

    listViewScore = (ListView) findViewById(R.id.score_list);

    adapter = new ScoreListAdapter(ctx, R.layout.score_row_item, listScore);
    listViewScore.setAdapter(adapter);
    adapter.notifyDatasetChanged(); 
}
}
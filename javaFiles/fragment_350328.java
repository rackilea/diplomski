public class MainActivity extends AppCompatActivity {

private SportNews sportNews;
private List<Article> articleList = new ArrayList<Article>();

private ArticleAdapter articleAdapter;
@BindView(R.id.recyclerView)
RecyclerView recyclerView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    SportInterface sportInterface = SportClient.getApiService();
    Call<SportNews> call = sportInterface.getArticles();
    call.enqueue(new Callback<SportNews>() {
        @Override
        public void onResponse(Call<SportNews> call, Response<SportNews> response) {
            sportNews =  response.body();
            if(sportNews != null && sportNews.getArticles() != null){
                articleList.addAll(sportNews.getArticles());
            }
            articleAdapter = new ArticleAdapter( articleList, sportNews);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(articleAdapter);
        }

        @Override
        public void onFailure(Call<SportNews> call, Throwable t) {

        }
    });

}
}
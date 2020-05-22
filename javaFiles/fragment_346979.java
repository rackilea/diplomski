public class HomeActivity extends AppCompatActivity implements HomeView{


@BindView(R.id.recyclerView)
RecyclerView recyclerView;
@BindView(R.id.btn_refresh)
FloatingActionButton btn_refresh;

HomePresenter presenter;
private List<PokemonData.Pokemon> items = new ArrayList<>();

private static int offset;

private static boolean isLoading;
private RecyclerViewHomeAdapter homeAdapter;

public static void setIsLoading(boolean isLoading) {
    HomeActivity.isLoading = isLoading;
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);
    presenter = new HomePresenter(this);
    presenter.getData(offset);
    offset = 0;
    isLoading = true;

    homeAdapter = new RecyclerViewHomeAdapter(items, this);

    recyclerView.setAdapter(homeAdapter);
    GridLayoutManager layoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);

    recyclerView.setLayoutManager(layoutManager);
    recyclerView.addOnScrollListener(new RecyclerViewOnScroll() {
        @Override
        protected void loadMore() {

            if (isLoading) {
                offset+=30;
                presenter.getData(offset);
                isLoading = false;
                homeAdapter.setPokemonList(items);
            }
        }
    });

}

@Override
public void setData(List<PokemonData.Pokemon> pokemons) {
    items.addAll(pokemons);
    homeAdapter.setPokemonList(items)

}}
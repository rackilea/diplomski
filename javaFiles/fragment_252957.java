import android.support.v4.app.Fragment;
public class MyFragment extends Fragment {
    RecyclerView rv_grid_movies;
    MoviesAdapter moviesAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movies, container, false);
        rv_grid_movies = rootView.findViewById(R.id.rv_grid_movies);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(), 2);
       // rv_grid_movies.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(3), true));
        rv_grid_movies.setItemAnimator(new DefaultItemAnimator());
        rv_grid_movies.setLayoutManager(manager);
        rv_grid_movies.setHasFixedSize(true);

        Model model = ViewModelProviders.of(this).get(Model.class);


        model.getMovies().observe(this, new Observer<List<MovieList>>() {
            @Override
            public void onChanged(@Nullable List<MovieList> movieLists) {
                moviesAdapter=new MoviesAdapter(getActivity(),movieLists);
                rv_grid_movies.setAdapter(moviesAdapter);
            }
        });
        return rootView;
    }
}
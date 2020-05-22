...
GridView mGridView;

@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_movie, container, false);
    mGridView = view.findViewById(R.id.movie_grid);
    return view;
}

public void setAdapter(BaseAdapter adapter) {
    mGridView.setAdapter(adapter);
}
...
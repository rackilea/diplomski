@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
View rootView = inflater.inflate(R.layout.fragment_songs, container, false);
mRecyclerView = (FastScrollRecyclerView) rootView.findViewById(R.id.rvSongs);
//Rest of the things
}
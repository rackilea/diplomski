@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_main, container, false);
    GridView gridView = (GridView) view.findViewById(R.id.gridview);
    gridView.setAdapter(new MyAdapter(getActivity()));
    return view;
}
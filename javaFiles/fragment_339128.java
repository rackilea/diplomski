@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    View view = inflater.inflate(R.layout.fragment_titles, container, false);
    lv=(ListView)view.findViewById(R.id.lv_t);

    sa=new SongAdapter(this.getContext(),lv.getId(),Helper.getSongs());
    lv.setAdapter(sa);

    return view;
}
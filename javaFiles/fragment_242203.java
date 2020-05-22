@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View v =inflater.inflate(R.layout.tab_1,container,false);
    txtResponsec=(TextView)v.findViewById(R.id.txtResponsecId);
    return v;
}
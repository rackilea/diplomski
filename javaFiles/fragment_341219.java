...

@Override
public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState)
{
    View view = inflater.inflate(R.layout.fragment_show_info, container, false);
    namePoi = intent.getStringExtra("name");
    name = (TextView) view.findViewById(R.id.showNameInfo);
    city = (TextView) view.findViewById(R.id.showCityInfo);
    country = (TextView) view.findViewById(R.id.showCountryInfo);
    date = (TextView) view.findViewById(R.id.showDateInfo);
    comment = (TextView) view.findViewById(R.id.showCommentInfo);
    cat = (TextView) view.findViewById(R.id.showCatInfo);

    lat = getArguments().getDouble("lat", 0);
    lng = getArguments().getDouble("lng", 0);
    latView = (TextView) view.findViewById(R.id.showLatInfo);
    lngView = (TextView) view.findViewById(R.id.showLngInfo);
    Log.d("debug", getArguments().getString("cat"));
    CharSequence tmp = getArguments().getString("name");
    name.setText(tmp);
    city.setText(getArguments().getString("city"));
    country.setText(getArguments().getString("country"));
    date.setText(getArguments().getString("date"));
    comment.setText(getArguments().getString("comment"));
    name.setText(getArguments().getString("name"));
    cat.setText(getArguments().getString("cat"));
    lngView.setText(String.valueOf(lng));
    latView.setText(String.valueOf(lat));
    return view;
}
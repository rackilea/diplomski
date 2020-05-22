private Double latitude;
private Double longitude;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    View view = inflater.inflate(R.layout.fragment_weather, container, false);

    latitude = this.getArguments().getDouble("latitude");
    longitude = this.getArguments().getDouble("longitude");

}
}
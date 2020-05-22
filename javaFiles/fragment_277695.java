@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    // Inflate the "decor.xml"
    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    DrawerLayout drawer = (DrawerLayout) inflater.inflate(R.layout.decor, null); // "null" is important.

    // HACK: "steal" the first child of decor view
    ViewGroup decor = (ViewGroup) getWindow().getDecorView();
    View child = decor.getChildAt(0);
    decor.removeView(child);
    FrameLayout container = (FrameLayout) drawer.findViewById(R.id.container); // This is the container we
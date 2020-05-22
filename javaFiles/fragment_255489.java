@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.base_activity);
    onCreateDrawer();

    LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

    // Here, ask the derived class for the layout resource to inflate into the content frame layout
    View stubView = inflater.inflate(getContentLayoutResId(), frameLayout, false);
    frameLayout.addView(stubView, lp);
}

abstract protect int getContentLayoutResId();
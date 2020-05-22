public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_1, container, false);
        return v;
     }

public void onViewCreated(View container, @Nullable Bundle savedInstanceState)
    {
        initUI();
        countDownStart();
    }
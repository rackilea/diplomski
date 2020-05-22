public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    ReadRSS readRSS = new ReadRSS(// I Pass them all Here );
    readRSS.execute();

    return inflater.inflate(R.layout.fragment_home, container, false);
}
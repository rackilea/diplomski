private String[] titles;

@Override
protected void onCreate(Bundle savedInstanceState) {
    ....
    titles = new String[] { getString(R.string.matches), getString(R.string.players) };
    ....
}
public static class PlaceholderFragment extends FXFragment {

    public PlaceholderFragment() {
        String fxapp = "your.package.myfragment.MainFX";
        this.setName(fxapp);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
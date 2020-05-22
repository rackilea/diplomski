public class Youtube extends FragmentActivity {
    public static final String API_KEY = "MyKey";
    public static final String VIDEO_ID = "videoID";
    public YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PlayerYouTubeFrag myFragment = PlayerYouTubeFrag.newInstance("Adp1TUDRNtc");
        getSupportFragmentManager().beginTransaction().replace(view.findViewById(R.id.placeholder).getId(), myFragment).commit();
    }
}
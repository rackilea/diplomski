public class HelloMoonFragment extends Fragment {

    private Button mPlayButton;
    private Button mStopButton;

    private MediaPlayer mPlayer;
    private boolean mCompleted =  false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);

        mPlayButton = (Button) v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setText("Play");

        mPlayButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(mPlayer == null) {
                    mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
                    mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            stopMediaPlayer();
                            mPlayButton.setText("Play");
                        }
                    });
                }

                if(mPlayButton.getText().equals("Play")) {
                    mPlayButton.setText("Pause");
                    mPlayer.start();
                }
                else if(mPlayButton.getText().equals("Pause")){
                    mPlayButton.setText("Play");
                    mPlayer.pause();
                }
            }
        });

        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
                stopMediaPlayer();
                mPlayButton.setText("Play");
           }
        });

        return v;
    }

    @Override
    public void onDestroy() {
        stopMediaPlayer();
        super.onDestroy();
    }


    public void stopMediaPlayer() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
}
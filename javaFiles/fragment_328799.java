public class FragmentMediaPlayer extends Fragment implements OnSeekBarChangeListener {

    private MediaPlayer mediaPlayer;
    public TextView duration;
    private int timeElapsed = 0, finalTime = 0;
    private int forwardTime = 5000, backwardTime = 5000;
    private Handler durationHandler = new Handler();
    private SeekBar seekBar;
    private boolean pausedFromButton = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.media_player, container,
                false);

        // Initialize different views from the layout
        duration = (TextView) rootView.findViewById(R.id.songDuration);
        duration.setText(String.format(
                "%d min, %d sec",
                0,0));

        seekBar = (SeekBar) rootView.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        ImageButton playButton = (ImageButton) rootView.findViewById(R.id.media_play);
        playButton.setOnClickListener(new OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         play();
                     } 
           }); 

        ImageButton media_pause = (ImageButton) rootView.findViewById(R.id.media_pause);
        media_pause.setOnClickListener(new OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         pause();
                     } 
           }); 

        ImageButton media_ff = (ImageButton) rootView.findViewById(R.id.media_ff);
        media_ff.setOnClickListener(new OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         forward();
                     } 
           }); 

        ImageButton media_rew = (ImageButton) rootView.findViewById(R.id.media_rew);
        media_rew.setOnClickListener(new OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         rewind();
                     } 
           }); 

        return rootView;
    }   

    @Override
    public void onResume() {
        super.onResume();   
        prepareMediaPlayer();   
        play();
    }

    @Override
    public void onPause() {
        super.onPause();
        //Not call pause because it's necessaty to distinguish between onPause() and when the user press the pause buttonn
        mediaPlayer.pause();
    }

    @Override
    public void onStop() {
        // Stop updates and Disconnect from Services
        mediaPlayer.stop();
        durationHandler.removeCallbacks(updateSeekBarTime);
        super.onStop();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
        if(fromUser) { 
            mediaPlayer.seekTo(progress); 
            seekBar.setProgress(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar arg0) {
        // TODO Auto-generated method stub

    }

    /**
     * Prepare MediaPlayer and recover from bad status
     */
    private void prepareMediaPlayer() {
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.song);
        finalTime = mediaPlayer.getDuration();
        seekBar.setMax(finalTime);
        mediaPlayer.seekTo(timeElapsed);
        mediaPlayer.setOnPreparedListener(new OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        mediaPlayer.setOnCompletionListener(new
                OnCompletionListener() {        
                    @Override
                    public void onCompletion(MediaPlayer arg0) {
                        pausedFromButton = true;
                    }
        });
    }

    /**
     * play mp3 song
     */
    public void play() {
        if(pausedFromButton) {
            prepareMediaPlayer();
            pausedFromButton = false;
        }       
        seekBar.setProgress(timeElapsed);
        durationHandler.postDelayed(updateSeekBarTime, 100);
    }

    /**
     * handler to change seekBarTime
     */
    private Runnable updateSeekBarTime = new Runnable() {
        public void run() {
            // get current position
            timeElapsed = mediaPlayer.getCurrentPosition();
            // set seekbar progress
            seekBar.setProgress(timeElapsed);
            // set time remaing
            //double timeRemaining = finalTime - timeElapsed;
            duration.setText(String.format(
                    "%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) timeElapsed),
                    TimeUnit.MILLISECONDS.toSeconds((long) timeElapsed)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                                    .toMinutes((long) timeElapsed))));

            // repeat yourself that again in 100 miliseconds
            durationHandler.postDelayed(this, 100);         
        }
    };


    /**
     * pause mp3 song
     */
    public void pause() {
        mediaPlayer.pause();    
        timeElapsed = mediaPlayer.getCurrentPosition();
        pausedFromButton = true;
    }

    /**
     * go forward at forwardTime seconds
     */
    public void forward() {
        // check if we can go forward at forwardTime seconds before song endes
        if ((timeElapsed + forwardTime) <= finalTime) {
            timeElapsed = timeElapsed + forwardTime;

            // seek to the exact second of the track
            mediaPlayer.seekTo(timeElapsed);
        }
    }

    /**
     * go backwards at backwardTime seconds
     */
    public void rewind() {
        // check if we can go back at backwardTime seconds after song starts
        if ((timeElapsed - backwardTime) > 0) {
            timeElapsed = timeElapsed - backwardTime;

            // seek to the exact second of the track
            mediaPlayer.seekTo(timeElapsed);
        }
    }   


}
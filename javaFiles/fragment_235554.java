//edited here
private int position = 1;
private MediaController mMediaController;

@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    mMediaController = new MediaController(getActivity());
    ...
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
{

    if (savedInstanceState != null)
    {
        position = savedInstanceState.getInt("position");
    }

    View v = inflater.inflate(R.layout.fragment_video_view, parent, false);

    mVideoView = (VideoView) v.findViewById(R.id.fragmentVideoView);
    mVideoView.setVideoPath(videoPath);
    mVideoView.setMediaController(mMediaController);

    mVideoView.setOnTouchListener(new View.OnTouchListener()
    {
        @Override
        public boolean onTouch(View v, MotionEvent motionEvent)
        {
            if (mVideoView.isPlaying())
            {
                mVideoView.pause();
                if (!getActivity().getActionBar().isShowing())
                {
                    getActivity().getActionBar().show();
                    mMediaController.show(0);
                }
                position = mVideoView.getCurrentPosition();
                return false;
            }
            else
            {
                if (getActivity().getActionBar().isShowing())
                {
                    getActivity().getActionBar().hide();
                    mMediaController.hide();
                }
                mVideoView.seekTo(position);
                mVideoView.start();
                return false;
            }
        }
    });

    mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer)
        {
            //here
            mVideoView.seekTo(1);
        }
    });
    //here
    if (position != 1)
    {
        mVideoView.seekTo(position);
        mVideoView.start();
    }
    else
    {
         //here
         mVideoView.seekTo(1);
    }
}

@Override
public void onSaveInstanceState(Bundle savedInstanceState)
{
    super.onSaveInstanceState(savedInstanceState);

    if (mVideoView != null)
    {
        savedInstanceState.putInt("position", mVideoView.getCurrentPosition());
    }

    mVideoView.pause();
}
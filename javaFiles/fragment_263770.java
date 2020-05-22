public class OneFragment extends Fragment {
    //static WebView mWebview;
    public OneFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        final TextView tvFragmentOne = (TextView) rootView.findViewById(R.id.tvFragmentOne);
        SeekBar lSeekBar = (SeekBar) rootView.findViewById(R.id.seekBar);
        lSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvFragmentOne.setTextSize(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        return rootView;
    }
}
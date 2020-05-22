@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.step22_fragment, container, false);
    Runnable delayedTask = new Runnable() {
        @Override
        public void run() {
            Log.d("PPP : ","456");
        }
    };
    v.postDelayed(delayedTask, 10000);
    return v;
}
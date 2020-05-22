public static class PlaceholderFragment extends Fragment {
    Button btn_A;
    Button btn_B;
    TextView hello;
    ObjectAnimator mAnimation;
    AnimatorSet transSet;
    Float valuefrom=0f;
    Float valueto=-360f;

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container,
                false);
        btn_A= (Button) rootView.findViewById(R.id.button1);
        btn_B= (Button) rootView.findViewById(R.id.button2);
        hello= (TextView) rootView.findViewById(R.id.textView1);

        btn_A.setOnClickListener(new OnClickListener() 
        {         
            public void onClick(View v) 
            {
                if(!transSet.isRunning()){
                    transSet.start();
                }
            }
        });

        btn_B.setOnClickListener(new OnClickListener() 
        {         
            public void onClick(View v) 
            {
                Float save = (Float) mAnimation.getAnimatedValue();
                Log.d("TAG", "Value" +save);
                valuefrom= save;
                valueto= save-360;
                transSet.cancel();
                //re-init the animation
                doObjectAnimator();
            }
        });

        //init the animation
        doObjectAnimator();
        return rootView;
    }

    public void doObjectAnimator(){
        mAnimation= ObjectAnimator.ofFloat(hello, "rotation", valuefrom, valueto);
        mAnimation.setInterpolator(new LinearInterpolator());
        mAnimation.setDuration(5000);
        mAnimation.setRepeatCount(Animation.INFINITE);
        mAnimation.setRepeatMode(Animation.RESTART);
        //define your other animations here and add them to the set like: set.play(anim1).before(anim2);
        transSet= new AnimatorSet();
        transSet.play(mAnimation);

    }
}
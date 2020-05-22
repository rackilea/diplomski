@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {

 Handler mHandler = new Handler();
 Thread animationThread = new Thread(new Runnable(){
   @Override public void run(){
        mHandler.post(animateView);
   }

 });

 animationThread.start();
  ...
}

 Runnable animateView = new Runnable(){
    @Override public void run(){
       final ImageView rotatingCog = (ImageView) getView().findViewById(R.id.bgCog);
       final Animation animRotate = AnimationUtils.loadAnimation(getActivity(),     R.anim.rotate_cog);
      rotatingCog.startAnimation(animRotate);
   }

 };


}
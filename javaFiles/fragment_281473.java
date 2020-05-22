final View top = (View) view.findViewById(R.id.top);
    final View bottom = (View) view.findViewById(R.id.bottom);
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {

            int topLoc[] = new int[2];
            top.getLocationOnScreen(topLoc);
            int BottomLoc[] = new int[2];
            bottom.getLocationOnScreen(BottomLoc);
            Log.d(Constants.debug, "topY: "+ topLoc[1]+" BottomY:" + BottomLoc[1]);
        }
    },4000);
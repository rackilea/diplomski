@Override
    public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            View view = getView()
            if(view != null){
                ViewCompat.requestApplyInsets(view)
            }
        }
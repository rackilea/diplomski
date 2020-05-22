public void refreshMyRecyclerView() {
    new Thread(new Runnable(){
        @Override
        public void run(){
            mValueList = mMyDatabase.fillValueList(); //pulls data from sqlite db
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mRecyclerAdapter = new MyRecyclerAdapter(getActivity(), mValueList);
                    mRecyclerView.setAdapter(mRecyclerAdapter);
                }
            });
        }
    }).start();
}
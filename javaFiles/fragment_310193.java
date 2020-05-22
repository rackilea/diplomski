if(m_Toolbar.getVisibility() == View.VISBILE) {
    ...........
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            m_Toolbar.setVisibility(View.GONE);
        }
    }, 3000);//3 seconds
}
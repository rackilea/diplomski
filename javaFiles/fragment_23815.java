private void setUpGoToTouchListener() {
    goTo.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
             FragmentManager fm = MainActivity.this.getFragmentManager();
             GoToDialog dialog = new GoToDialog();
             Bundle bundle = new Bundle();
             bundle.putInt("Size", defMan.getTotalCount());
             dialog.setArguments(bundle);
             dialog.show(fm, "Manager");
             return true;
        }
    });
}
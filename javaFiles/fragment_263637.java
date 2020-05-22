menu.setOnTouchListener(new OnSwipeTouchListener(this){
    @Override public void onSwipeRight()
    {
        Menu.this.finish();
    }
}
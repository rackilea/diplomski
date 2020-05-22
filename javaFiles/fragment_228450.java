final ViewGroup myViewGroup = (ViewGroup) findViewById(R.id.my_viewgroup);
ViewTreeObserver vto = myViewGroup.getViewTreeObserver();
vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
        //myViewGroup should now have dimensions, but sometimes
        //it takes two passes, so...
        if(myViewGroup.getWidth() == 0) return;

        //Set whatever stuff here
        myTileSizes = whateverSize;

        //Remove this listener -- no longer needed
        myViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}
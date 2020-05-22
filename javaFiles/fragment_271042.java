public boolean onTouch(View view,MotionEvent event){
    x=(int)event.getX()-(radius/2);
    y=(int)event.getY()-(radius/2);
    randColor();
    invalidate();
    Toast.makeText(getContext(), 
        ColorUtils.findClosestColor(new int[]{r, g, b}, ColorUtils.COLOR_MAP), Toast.LENGTH_LONG).show();
    return true;
}
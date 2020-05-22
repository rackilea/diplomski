private int asynchCounter = 0;
private void updateCounter(int delta){
    asynchCounter+=delta;
    if(asynchCounter<=0){
        progress.setVisibility(View.GONE);
    }else{
        progress.setVisibility(View.VISIBLE);
    }
}
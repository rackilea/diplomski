public void onClick(View v) {
    //...
    if (v.getId()==R.id.slideButton){ //Slideshow button
        toggle^= true;
        if(toggle==true){
            timer = new Timer();
            timer.schedule(/*Whatever TimerTask you had here before*/);         
        }
        else{
            timer.cancel();
        }
    }//end if(slide button)
}//end onClick()
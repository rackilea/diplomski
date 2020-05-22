Animation img = AnimationUtils.loadAnimation(context, R.anim.fade); //no need to use getApplicationContext I think
logo.startAnimation(img);

img.setAnimationListener(new Animation.AnimationListener(){
@Override
public void onAnimationStart(Animation arg0) {
}           
@Override
public void onAnimationRepeat(Animation arg0) {
}           
@Override
public void onAnimationEnd(Animation arg0) {
   //try to clear the image here
   logo.setImageDrawable(null);

   //or you can make the imageview to invisible
   logo.setVisibility(View.INVISIBLE);
}
});
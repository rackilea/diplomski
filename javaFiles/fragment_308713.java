public void clickEventSlide(){

 if(mSlideState){ 
mDrawerLayout.closeDrawer(Gravity.END); 
}else{ mDrawerLayout.openDrawer(Gravity.END); }
}
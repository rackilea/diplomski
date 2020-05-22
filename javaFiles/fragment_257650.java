public void sideBar()
{
   ImageView sidebar = (ImageView)findViewById(R.id.sidebar);

   mSlideInRight = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
   mSlideInRight.setFillAfter(true);
   sidebar.startAnimation(mSlideInRight);
}
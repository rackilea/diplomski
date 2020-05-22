mDrawerLayout.setDrawerListener
(new ActionBarDrawerToggle
(this, mDrawerLayout, R.drawable.ic_menu_slide, 0, 0){
 @Override 
public void onDrawerClosed
(View drawerView) {
 super.onDrawerClosed
(drawerView);
 mSlideState=false;//is Closed
 } 
@Override 
public void onDrawerOpened
(View drawerView) { 
super.onDrawerOpened(drawerView); mSlideState=true;//is Opened }});
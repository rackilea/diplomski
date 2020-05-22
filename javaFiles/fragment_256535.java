new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
if(navDrawer.isOpened()){
        navDrawer.closeDrawers();
}
    }
},2000);
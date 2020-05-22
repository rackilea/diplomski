FragmentManager fragmentManager = YourActivity.this.getSupportFragmentManager();
List<Fragment> fragmentList = fragmentManager.getFragments();
if(fragment != null && fragment.isVisible()) {
    //user is still in settings or sub-settings
}else{
     //do something else
}
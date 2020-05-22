int myIntValue = sharedPreferences.getInt("motivator", -1);
if(myIntValue != viewPager.getCurrentItem()){
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt("motivator", viewPager.getCurrentItem());
    editor.apply();
    myIntValue = sharedPreferences.getInt("motivator", -1);
}
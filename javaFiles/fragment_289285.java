public void getSharedPreferencesOnStart() {

            String s = myTabPagerAdapter.makeFragmentName(myViewPager.getId(),myViewPager.getCurrentItem());
            SpotPosition sp =  (SpotPosition) myTabPagerAdapter.getItem(0);

            // sp.setSettings();//In this call i am getting null pointer
            SharedPreferences prefs = getSharedPreferences("message",MODE_PRIVATE);
Editor editor = prefs.edit();
editor.putBoolean("say_hello",true")
editor.commit();
    ...}
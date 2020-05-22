FragmentTest Mfragmenttest = new FragmentTest();
FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
//R.id.frameLayout is our frame layouts id. 
 ft.add(R.id.frameLayout, Mfragmenttest , "Hello Fragment");
ft.commit
//create the new fragment
Fragment newFragment = new MyFragment();

//start a fragment transaction
FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

//replace the old fragment with the new
transaction.replace(R.id.frame, newFragment).commit();
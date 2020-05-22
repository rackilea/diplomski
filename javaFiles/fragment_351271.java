Fragment newFragment = new FragmentMap();
FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

transaction.replace(R.id.detail_container, newFragment);
transaction.addToBackStack(null);
transaction.commit();
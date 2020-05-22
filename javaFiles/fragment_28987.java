mFragment = new MyFragment();
Bundle extras = this.getIntent().getExtras();
extras.putInt("category", 10);
mFragment.setArguments(extras);
mFragmentTransaction = getSupportFragmentManager().beginTransaction();
mFragmentTransaction.add(R.id.profile_fragment, mFragment);
mFragmentTransaction.commit();
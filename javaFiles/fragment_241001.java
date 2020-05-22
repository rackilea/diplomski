PamperPartyFragment mPamperPartyFragment = new PamperPartyFragment();
    Bundle bundle = new Bundle();
    bundle.putInt(key, value);
    mPamperPartyFragment.setArguments(bundle);

 mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.fragment_container_massage,
                      mPamperPartyFragment  ).commit();
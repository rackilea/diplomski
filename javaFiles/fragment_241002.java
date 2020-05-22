Bundle bundle = new Bundle();
    bundle.putString("spinnerValue",parent.getItemAtPosition(position).toString());
    mPamperPartyFragment.setArguments(bundle);
    mFragmentTransaction = mFragmentManager.beginTransaction();
    mFragmentTransaction.replace(R.id.fragment_container_massage,
            mPamperPartyFragment  ).commit();
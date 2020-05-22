if(position==0){
            FragmentTransaction mTransaction = getSupportFragmentManager()
                    .beginTransaction();
            SupportMapFragment mFRaFragment = new mapsFragment();
            mTransaction.replace(R.id.container, mFRaFragment);
            mTransaction.commit();
        }else {
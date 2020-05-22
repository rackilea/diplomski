if (findViewById(R.id.detail_container) != null) {
            mTwoPane = true;
        }
FragmentWCLine newFragment = new FragmentWCLine();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.master_container, newFragment);
        transaction.commit();
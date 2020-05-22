if (mTopicFragment !=null){
        getSupportFragmentManager().beginTransaction().remove(mTopicFragment).commit();
    }
        mTopicFragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putParcelable(getString(R.string.intentCourse), course_info);
        mTopicFragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_host, mTopicFragment,getString(R.string.tag_fragment_topic));
        transaction.commit();
        mFragmentTags.add(getString(R.string.tag_fragment_topic));
        mFragments.add(new FragmentTag(mTopicFragment, getString(R.string.tag_fragment_topic)));

        mFragmentTags.remove(getString(R.string.tag_fragment_topic));
        mFragmentTags.add(getString(R.string.tag_fragment_topic));

    setFragmentVisibilities(getString(R.string.tag_fragment_topic));
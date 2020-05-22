final ViewPager viewPager = (ViewPager) findViewById(R.id.myviewpager);
    MyAdapter adapter = new MyAdapter(getSupportFragmentManager());

    // Add your fragments in adapter.
    FragmentOne fragmentOne = new FragmentOne();
    adapter.addFragment(fragmentOne, getResources().getString(R.string.fragment_one_title));

    FragmentTwo fragmentTwo = new FragmentTwo();
    adapter.addFragment(fragmentTwo, getResources().getString(R.string.fragment_two_title));

    viewPager.setAdapter(adapter);
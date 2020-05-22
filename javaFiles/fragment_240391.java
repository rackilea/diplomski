private SPager myViewPager;

//...

myViewPager = view.findViewById(R.id.mPager);

//...

myViewPager.initFragmentManager(getChildFragmentManager());
myViewPager.addPages("Inner fragment 1", new IFragOne());
myViewPager.addPages("Inner fragment 2", new IFragTwo());
myViewPager.build();
SampleFragment myFragment; // declared in your activity class

// This is small change in your setupViewPager
myFragment = new SampleFragment ();
adapter.addFrag(myFragment, context.getResources().getString(R.string.info));

//later on when you want to call getToast:
myFragment.getToast();
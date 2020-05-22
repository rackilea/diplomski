MyFragment myFragment = new MyFragment();
fragmentManager = getSupportFragmentManager();
Bundle bundle = new Bundle();
bundle.putSerializable("myArrayTag", myList);
myFragment.setArguments(bundle);
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
fragmentTransaction.add(R.id.fragment_container, myFragment,"myFragmentTag").commit();
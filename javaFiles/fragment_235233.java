Bundle args = new Bundle();        
// add needed args

//create fragment and set arguments    
Fragment fragment= MyFragment();
fragment.setArguments(args)

FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
// getSupportFragmentManager - uses for compatible library instead of getFragmentManager

//replace frame with our fragment
ft.replace(R.id.fragmentForChange,fragment);
//set type of animation
ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

//finish transaction
ft.commit();
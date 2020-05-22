FragmentManager fragmentManager = getFragmentManager();
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
fragmentTransaction.replace(R.id.frame_container, mBaseFragment);  
fragmentTransaction.addToBackStack(null);
// Commit the transaction
fragmentTransaction.commit();
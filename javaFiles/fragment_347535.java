FragmentManager fragmentManager = getFragmentManager();
FragmentTransaction transaction =fragmentManager.beginTransaction();
Fragment fragment = new CustomFragment(); // your fragment to add
transaction.replace(R.id.content_frame, fragment,CustomFragment.TAG); // a string in case you need to check with fragment is currently visible.
transaction.addToBackStack(null);
transaction.commit();
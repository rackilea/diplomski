FragmentManager fragmentManager = getFragmentManager();  
FragmentTransaction fragmentTransaction = fragmentManager  
        .beginTransaction();  
DetailFragment fragment3 = new DetailFragment();  
fragmentTransaction.replace(R.id.Framelay, fragment3);  
fragmentTransaction.commit();
GalleryFragment fr = new GalleryFragment();
Bundle args = new Bundle();
fr.setArguments(args);
FragmentManager fm = getFragmentManager();
FragmentTransaction fragmentTransaction = fm.beginTransaction();
fragmentTransaction.replace(R.id.gallery_fragment, fr);
fragmentTransaction.commit();
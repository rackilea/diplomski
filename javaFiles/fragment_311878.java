int myData=12;
FragmentManager manager = getActivity().getSupportFragmentManager();
Fragment frgObj=FragmentTwo.newInstance(myData);
FragmentTransaction ft = manager.beginTransaction();
ft.replace(R.id.container, frgObj,"FragmentTwo");
ft.addToBackStack(null);
ft.commit();
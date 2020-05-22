FragmentTransaction ft = getFragmentManager().beginTransaction();
ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);

newsFrag1 newsFragment1 = new newsFrag1();
ft.replace(R.id.fragment_container, newsFragment1);
ft.addToBackStack();
ft.commit();
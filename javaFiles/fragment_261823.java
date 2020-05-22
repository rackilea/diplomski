private void loadCalFragment() {
   String string1,string2 = "Hii"

    CalFragment fragment = CalFragment.newInstance(string1,string2);
    FragmentTransaction ft = getFragmentManager().beginTransaction();
    ft.replace(R.id.fragment_frame, fragment);
    ft.commit();
}
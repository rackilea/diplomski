private void replaceFragment (Fragment fragment){
  String backStateName = fragment.getClass().getName();

  FragmentManager manager = getSupportFragmentManager();
  boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);

  if (!fragmentPopped){ //fragment not in back stack, create it.
    FragmentTransaction ft = manager.beginTransaction();
    ft.replace(R.id.content_frame, fragment);
    ft.addToBackStack(backStateName);
    ft.commit();
  }
}
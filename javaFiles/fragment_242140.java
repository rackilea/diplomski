private void addFragment(Fragment fragment) {
 // create a FragmentManager
    FragmentManager fm = getSupportFragmentManager();
   // create a FragmentTransaction to begin the transaction and replace the Fragment
    FragmentTransaction fragmentTransaction = fm.beginTransaction();
   // replace the FrameLayout with new Fragment
    fragmentTransaction.replace(R.id.frameLayout, fragment);
    fragmentTransaction.commit(); // save the changes
}
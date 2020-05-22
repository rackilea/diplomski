Fragment fragmentB=getFragmentManager().findFragmentByTag("FRAGMENT_B_TAG");
if (fragmentB!=null){
   getFragmentManager().popBackStackImmediate("FOO",
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
   attachFragmentB(fragmentB);
}

void attachFragmentB(Fragment fragmentB){
  //In portrait: Remove FragmentA, add FragmentB to containerYellow, addToBackstack("FOO")
  //In landscape: add FragmentB to contanerYellow, addToBackstack("FOO")
}
public void switchToSecondFragment(){
     FragmentManager manager = getSupportFragmentManager();
     FragmentB fragment = new SelectTipFragment();
     FragmentTransaction transaction = manager.beginTransaction();
     transaction.replace(R.id.container, fragment).addToBackStack(null);
     transaction.commit();
}
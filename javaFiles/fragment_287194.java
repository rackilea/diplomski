if (savedInstanceState == null){
  CrimeFragment fragment = new CrimeFragment();
  FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
  transaction.replace(R.id.fragmentContainer, fragment, "fragment").commit();
}else{
  CrimeFragment homeFragment = (CrimeFragment) getSupportFragmentManager().findFragmentByTag("fragment");
}
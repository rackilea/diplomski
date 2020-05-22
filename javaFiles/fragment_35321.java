@Override
public void sendData(String a, String b) {
    MainFragment mainFragment = new MainFragment();
    getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment).commit();
    mainFragment.showData(a,b); 
}
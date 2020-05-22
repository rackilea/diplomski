@Override
public void onBackPressed() {
    Fragment fr = getFragmentManager().findFragmentById(R.id.authentication_parent0_linear);

    // chek that mLoginFragment!=null, basically this should never happen! 

    if (fr == mLoginFragment) {
        super.onBackPressed();
    } else {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
      fragmentTransaction.replace(R.id.authentication_parent0_linear, mLoginFragment, LOGINTAG);
      fragmentTransaction.commit();
    }
}
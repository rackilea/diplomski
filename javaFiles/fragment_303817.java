@Override
public void onBackPressed() {

    if (getFragmentManager() != null && getFragmentManager().getBackStackEntryCount() >= 1) {

   String fragmentTag = getFragmentManager().findFragmentById(R.id.frame_container).getTag();

   if(fragmentTag.equals(LoginFragment.getTag())){
    // show Dialog code
      }else{
            super.onBackPressed();
      }

    } else {
         super.onBackPressed();
    }
}
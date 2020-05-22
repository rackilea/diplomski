@Override
public void onBackPressed() {
    Fragment fragment =getSupportFragmentManager().findFragmentById(R.id.containerFrame);
    if (fragment != null && fragment instanceof YourFragment) {
        if(((YourFragment) fragment).validate()){
         finish();
       }
    } else {
        super.onBackPressed();
    }
}
@Override
public void onBackPressed() {       
    Fragment frag = getSupportFragmentManager().findFragmentById(R.id.your_container);

    if(frag instanceof TheFragmentYouAreTalkingAbout) {
        ((TheFragmentYouAreTalkingAbout)frag).showConfirmGoBackDialog();
    } else {
        super.onBackPressed();
    }
}
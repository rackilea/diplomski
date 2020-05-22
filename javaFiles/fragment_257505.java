@Override
public void onStop() {
    super.onStop();
    if(mShouldFinish)
         finish();
}
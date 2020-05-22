@Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
    // Always call the superclass so it can save the view hierarchy 
       state
    super.onSaveInstanceState(savedInstanceState);
    savedInstanceState.putInt(GAME_INDEX, mHumanCounter);
    savedInstanceState.putInt(GAME_INDEX, mTieCounter);
    savedInstanceState.putInt(GAME_INDEX, mAndroidCounter);
    Log.i(TAG, "onSaveInstanceState(Bundle)");
}
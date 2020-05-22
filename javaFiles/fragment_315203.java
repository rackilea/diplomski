@Override

protected void onSaveInstanceState(Bundle state) {

    super.onSaveInstanceState(state);

   /*this line here save that the current orientation is landascepe */
     state.putChar('O','L'); 

}
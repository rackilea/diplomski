@Override
protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
     if (savedInstanceState != null) {       
          player1.setMyTurn(savedInstanceState.getBoolean("playerTurn")); 
     }
}
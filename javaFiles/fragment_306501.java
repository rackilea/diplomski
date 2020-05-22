@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
  super.onSaveInstanceState(savedInstanceState);
  // Save UI state changes to the savedInstanceState.
  // This bundle will be passed to onCreate if the process is
  // killed and restarted.
  savedInstanceState.putInt("cash", cash);
  savedInstanceState.putInt("anteBet", anteBet);
  savedInstanceState.putInt("playBet", playBet);
  savedInstanceState.putInt("pairPlusBet", pairPlusBet);
  savedInstanceState.putString("cashView", cashView.getText().toString());
  // etc.
}

@Override
public void onRestoreInstanceState(Bundle savedInstanceState) {
  super.onRestoreInstanceState(savedInstanceState);
  // Restore UI state from the savedInstanceState.
  // This bundle has also been passed to onCreate.
  cash = savedInstanceState.getInt("cash");
  anteBet = savedInstanceState.getInt("anteBet");
  playBet = savedInstanceState.getInt("playBet");
  pairPlusBet = savedInstanceState.getInt("pairPlusBet");
  cashView.setText(savedInstanceState.getString("cashView"));
}
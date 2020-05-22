if (level.getString("level","").equals("2")){
   String prevCoin =  sharedPreferences.getString("coin", "");
   Double newCoin = Double.parseDouble(prevCoin) + 5;
   coin.edit().putString("coin", Double.toString(newCoin)).apply();
   textviewcoinnum.setText(coin.getString("coin",""));
   //supposed to add 5 coins and set set the new value as text in a textView.
}
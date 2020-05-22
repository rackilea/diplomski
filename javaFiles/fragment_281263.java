ArrayList<String> players = new ArrayList<String>(); //declare it outside of the function

private TextView createNewTextView (String text){
    final LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    final TextView newTextView = new TextView(this);

    newTextView.setLayoutParams(lparams);
    newTextView.setText(text);
    players.add(text);
    return newTextView;
}

public void zacniIgro (View v){
    Intent zacniIgro = new Intent (getApplicationContext(), Igra.class);
    zacniIgro.putStringArrayListExtra("players", players);
    startActivity(zacniIgro);
}
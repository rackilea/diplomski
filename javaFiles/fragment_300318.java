for(String genre:m.getGenre()){
    TextView text = new TextView(context);
    LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    text.setLayoutParams(p);
    text.setText(genre);
    text.setTextAppearance(R.style.boldText);

    mgenre.addView(text);
}
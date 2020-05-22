private void openGameActivity(List<Game> currentYearCategory, int gameNum){
    ....

    String string = "test string";
    textView.setText(string);

    Intent intent = new Intent(getActivity(), GameActivity.class);
    intent.putExtra("SHARED_CONTENT", string);
    startActivity(intent);
}
String[] letters = {"s", "a"};
String randomSad = (letters[new Random().nextInt(letters.length)]);
tv1 = (TextView) findViewById(R.id.textview11);
tv1.setText(randomSad);

 button.setOnClickListener(new OnclickListener() {
    randomSad = (letters[new Random().nextInt(letters.length)]);
    tv1.setText(randomSad); //set the name in the index as text
});
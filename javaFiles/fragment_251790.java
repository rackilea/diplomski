String csv = final_data.replaceAll("\\[|\\]|s", "");
String[] numbers = csv.split(",");
// Toast.makeText(getBaseContext(), "Message : " + final_data, Toast.LENGTH_SHORT).show();
Random doubleNumberRandom = new Random();
String number = numbers[doubleNumberRandom.nextInt(numbers.length)];
TextView myText = (TextView) findViewById(R.id.textView);
myText.setText(number);
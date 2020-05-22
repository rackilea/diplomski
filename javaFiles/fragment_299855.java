//I'd like to store String s and Boolean b in the button.
button.setTag(R.id.string_key, s);
button.setTag(R.id.boolean_key, b);

//Now, I'd like to retrieve the data in new fields.
String new_s = (String) button.getTag(R.id.string_key);
Boolean new_b = (Boolean) button.getTag(R.id.boolean_key);
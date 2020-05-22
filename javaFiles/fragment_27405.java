String firstWord = "user";
String secondWord = "has been publish a beez";

// Create a new spannable with the two strings
Spannable spannable = new SpannableString(firstWord+secondWord);

// Set the custom typeface to span over a section of the spannable object
spannable.setSpan( new CustomTypefaceSpan("sans-serif",CUSTOM_TYPEFACE), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
spannable.setSpan( new CustomTypefaceSpan("sans-serif-light",SECOND_CUSTOM_TYPEFACE), firstWord.length(), firstWord.length() + secondWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

// Set the text of a textView with the spannable object
textView.setText( spannable );
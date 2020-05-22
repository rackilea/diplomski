// get the TextView instance first
TextView textView = ((TextView) rootView.findViewById(R.id.text2));
// then get the text in order to check if it begins with the tag
String text = args.getString(ARG_OBJECT2);
// find out if it begings with the tag
boolean beginsWithTag = text.startsWith("<#c>");

// then handle the case of a leading tag
if (beginsWithTag) {
    // replace the tag with an empty String and trim it
    text = text.replace("<#c>", "").trim(); // removes the leading tag 
    text.trim(); // removes all trailing or leading whitespaces
    textView.setGravity(Gravity.CENTER);
}

// finally just add the text
textView.setText();
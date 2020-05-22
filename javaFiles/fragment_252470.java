String[] array = new String[] { "A", "B", "C" };

int previousId = 0;

// Loop through all the Strings in the array
for(int i = 0; i < array.length; i++) {

    // Get the text from the array
    String text = array[i];

    // Create a new EditText
    EditText editText = new EditText(context);

    // To add the Rules for the position of the views later on we need to define an id.
    // In this case I assign the index in the array as Id, but in your app you should define
    // ids in values/ids.xml like this: <item name="firstEditText" type="id" /> and use these
    editText.setId(i + 1);

    // Set the text for the new EditText
    editText.setText(text);

    // Create the LayoutParams
    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    // Add the rules where to place the view.
    if(i == 0) {

        // The first EditText will be placed at the top of the parent.
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);

    } else {

        // All EditTexts after the first one are placed below the previous one.
        params.addRule(RelativeLayout.BELOW, previousId);

    }

    // We save the id of this EditText so we can position the next EditText below it.
    previousId = editText.getId();    

    // Add the view to your layout - in this case a RelativeLayout - with the LayoutParams we defined above
    relativeLayout.addView(editText, params);
}
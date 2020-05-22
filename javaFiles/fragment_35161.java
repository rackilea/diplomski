// get the EditText from the XML
this.editText = (EditText)this.findViewById(R.id.edittext);
this.editText.setOnKeyListener(etOnKeyListener);

// Create a new EditText
EditText modifiedText = new EditText(this);
modifiedText.setText("Foo Bar");

// reassign the reference to modified text
this.editText = modifiedText;
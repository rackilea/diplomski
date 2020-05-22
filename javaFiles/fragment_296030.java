LayoutInflater factory = LayoutInflater.from(this);        
final View textEntryView = factory.inflate(R.layout.dialog, null);

resultOne=(TextView)textEntryView.findViewById(R.id.resultOne); //resultone is a textview in xml dialog

resultOne.setText("hello");
alert.setView(textEntryView);

alert.show();
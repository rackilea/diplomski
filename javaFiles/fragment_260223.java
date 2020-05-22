// send where details is object
ClassName details = new ClassName();
Intent i = new Intent(context, EditActivity.class);
i.putExtra("Editing", details);
startActivity(i);


//receive
ClassName model = (ClassName) getIntent().getSerializableExtra("Editing");

And 

Class ClassName implements Serializable {
}
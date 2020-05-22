// Create an array of things to create views from.
// You will probably be getting your array from somewhere else
YourObjectHere[] things = new YourObjectHere[2];
things[0] = new YourObjectHere();
things[1] = new YourObjectHere();

// Get a reference to a LinearLayout to hold your views
LinearLayout list = (LinearLayout) findViewById(R.id.list);

// Loop through your list of objects
for(int i = 0; i < things.length; i++) {

    // Inflate an instance of your layout
    View listItem = getLayoutInflater().inflate(R.layout.child, null);

    // Set the TextViews to the appropriate things
    ((TextView) listItem.findViewById(R.id.name)).setText(things[i].getName());
    ((TextView) listItem.findViewById(R.id.type)).setText(things[i].getType());

    // Add the inflated view to the list
    item.addView(child);
}
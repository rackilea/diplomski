TextView counter = (TextView) v.findViewById(R.id.myTextViewTwo);
if (counter != null) {
    counter.setText(myData.getCountAsString());
    // add the TextView for the counter to the HashMap.
    mCounterList.put(position, counter);
}
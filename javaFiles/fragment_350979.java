public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
    Activity activity = (Activity) parent.getContext();
    Intent myIntent = new Intent();
    if (pos == 0) {
        myIntent.setClassName(activity, MyActivity1.class);
    } else if (pos == 1) {
        myIntent.setClassName(activity, MyActivity2.class);
    }
    activity.startActivity(myIntent);
}
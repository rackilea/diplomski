@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
 MenuInflater inflater = getMenuInflater();
inflater.inflate(R.menu.main_activity_actions, menu);
return onCreateOptionsMenu(menu); //<--- conflicting line
}
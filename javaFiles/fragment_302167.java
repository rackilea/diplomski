@Override
public boolean onOptionsItemSelected(MenuItem item) {

    switch (item.getItemId()) {
        case R.id.action_notification: {
            // Do something
            Toast toast = Toast.makeText(this, "Notification clicked", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return true;
        }
        case R.id.action_task: {
            // Do something
            Toast toast = Toast.makeText(this, "Task clicked", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return true;
        }
    }
    return super.onOptionsItemSelected(item);
}
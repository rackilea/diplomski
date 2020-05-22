@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.custom_menu, menu);

    // Notification
    final MenuItem itemNotification = menu.findItem(R.id.action_notification);
    View actionViewNotification = MenuItemCompat.getActionView(itemNotification);
    actionViewNotification.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onOptionsItemSelected(itemNotification);
        }
    });

    // Task
    final MenuItem itemTask = menu.findItem(R.id.action_task);
    View actionViewTask = MenuItemCompat.getActionView(itemTask);
    actionViewTask.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onOptionsItemSelected(itemTask);
        }
    });

    return true;
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.mymenu, menu);
    menu.findItem(R.id.messages).setIcon(R.drawable.ic_action_email);
    return true;
}
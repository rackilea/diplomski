DBAdapter db = new DBAdapter(this);
try {
    db.open();
    db.UpdateOption("theme", "dark");
}
catch (Exception ex) {}
finally {
    db.close();
}
finish();
Intent intent = new Intent(this, ActionBarTabsPager.class);
intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
startActivity(intent);
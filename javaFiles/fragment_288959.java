AlertDialog.Builder alertbox = new AlertDialog.Builder(LauncherActivity.this);
alertbox.setTitle("Are you sure?");
alertbox.setPositiveButton("YES", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
Toast.makeText(LauncherActivity.this, "You Choose Yes!!", Toast.LENGTH_LONG).show();
}
});
alertbox.setNegativeButton("NO", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
Toast.makeText(LauncherActivity.this, "You Choose Nooo!!", Toast.LENGTH_LONG).show();
}
});
alertbox.show();
@Override
public void onClick(View v) {
    String link = linkinput.getText().toString();

    // Storing the link into the bundle to pass to the next Activity.
    Bundle bundle = new Bundle();
    bundle.putString("link", link);

    // Creating an Intent for which Activity to launch.
    Intent intent = new Intent((MainActivity.this, ToBrowseract.class);

    // Starting the new Activity with the Bundle with the link.
    startActivity(intent, bundle);
}
@Override
public void onBackPressed() {
    // You want to start B Activity
    Intent a = new Intent(this, B.class);

    // But you dont want it on top of E.
    a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

    // Launching this will now remove every activity on top of B and bring B to front, not! relaunch it.
    startActivity(a);
}
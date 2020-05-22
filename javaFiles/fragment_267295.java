....

@Override
public void onStart(Intent intent, int startId) {
    Toast.makeText(this, "Text: " + intent.getStringExtra("text"), Toast.LENGTH_LONG).show();
}
....
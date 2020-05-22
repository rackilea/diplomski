private void countSeconds() {
    Log.d(TAG, Integer.toString(++counter));

    Intent counterIntent = new Intent(BROADCAST_ACTION);
    counterIntent.putExtra("counter", counter);

    sendBroadcast(counterIntent);
}
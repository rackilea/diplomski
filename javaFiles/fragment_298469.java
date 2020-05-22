public int onStartCommand(Intent intent, int flags, int startId) {
    int cmd = super.onStartCommand(intent, flags, startId);

    if (intent == null) return cmd;

    final String author = intent.getStringExtra("author");
    final String quote = intent.getStringExtra("quote");

    ...
}
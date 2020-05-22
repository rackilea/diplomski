@Override
public int onStartCommand(Intent intent, int flags, int startId) {
     recognizer.cancel();
     recognizer.addKeyphraseSearch("usersKeywords", intent.getStringExtra("keyword"););
     recognizer.startListening("usersKeywords");
}
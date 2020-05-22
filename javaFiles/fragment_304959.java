try {
     Thread.sleep(3000);
     mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
} catch (InterruptedException e) {
     // it depends on your app logic what to do with InterruptedException, you can process it or rethrow or restore interrupted flag
}
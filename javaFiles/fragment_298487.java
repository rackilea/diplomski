// Specify how many results you want to receive. The results will be sorted
// where the first result is the one with higher confidence.
intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);

// ...
startActivityForResult(intent,0);
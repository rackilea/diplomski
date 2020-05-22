try {
    startActivityForResult(intent, REQ_CODE_SPEECH_OUTPUT);
} catch (ActivityNotFoundException a) {
    Toast.makeText(getApplicationContext(),
            getString(R.string.speech_not_supported),
            Toast.LENGTH_SHORT).show();
}
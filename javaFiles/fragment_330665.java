loginValidator(username, (success) -> {
    if (success) {
        String writeToFile = null;
        writeToFile = getTextToWrite();
        writeFileExternalStorage(writeToFile);
        Intent mainIntent = new Intent(LogInActivity.this, MainActivity.class);
        startActivity(mainIntent);
    } else
      infoText.setText(getString(R.string.UserNotFound));
});
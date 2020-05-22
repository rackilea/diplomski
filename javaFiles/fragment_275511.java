@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      if (requestCode != VOICE_RECOGNITION_REQUEST_CODE || resultCode != RESULT_OK) {
          return; // don't do anything
      }
      // Assume you have all data
      // ...
    }
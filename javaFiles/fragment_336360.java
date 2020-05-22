try {
    // Specify the IP camera’s URL and auth headers.
    _mediaPlayer.setDataSource(context, source, headers);

    // Begin the process of setting up a video stream.
    _mediaPlayer.setOnPreparedListener(this);
    _mediaPlayer.prepareAsync();
  } catch (Exception e) {}
String soundFile = "path/to/.wav/file";
InputStream in = new FileInputStream(soundFile );

// create an audiostream from the inputstream
AudioStream audioStream = new AudioStream(in);

// play the audio clip with the audioplayer class
AudioPlayer.player.start(audioStream);
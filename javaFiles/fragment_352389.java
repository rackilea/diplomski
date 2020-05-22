// Create the AudioData object from the byte array
AudioData audiodata = new AudioData(byteArray);
// Create an AudioDataStream to play back
AudioDataStream audioStream = new AudioDataStream(audioData);
// Play the sound
AudioPlayer.player.start(audioStream);
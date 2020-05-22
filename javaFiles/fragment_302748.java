writer.addVideoStream(videoStreamIndex, 0, videoCodec, width, height);
writer.addAudioStream(audioStreamIndex, 0, audioCodec, channelCount, sampleRate);

while (... have more data ...)
{
    BufferedImage videoFrame = ...;
    long videoFrameTime = ...; // this is the time to display this frame
    writer.encodeVideo(videoStreamIndex, videoFrame, videoFrameTime, DEFAULT_TIME_UNIT);

    short[] audioSamples = ...; // the size of this array should be number of samples * channelCount
    long audioSamplesTime = ...; // this is the time to play back this bit of audio
    writer.encodeAudio(audioStreamIndex, audioSamples, audioSamplesTime, DEFAULT_TIME_UNIT);
}
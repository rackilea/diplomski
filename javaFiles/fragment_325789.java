for(int i = 0; i < read/4; i = i + 4)
{
    leftChannelAudioData[i] = data[4*i];
    leftChannelAudioData[i+1] = data[4*i+1];
    rightChannelAudioData[i] =  data[4*i+2];
    rightChannelAudioData[i+1] = data[4*i+3];
}
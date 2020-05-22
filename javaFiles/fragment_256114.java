String[] temp = new String[] {
    "cmd", "/c",
    "ffmpeg\\ffmpeg.exe -i input_track.ac3 -threads 0 " + 
    "-af volume=volume=\"0.0\"dB -acodec pcm_s32le -ac 6 " +
    "-ar 48000 -f wav - | " +
    "ffmpeg\\fdkaac --ignorelength -m 1 -o ouput_track.aac -"
};
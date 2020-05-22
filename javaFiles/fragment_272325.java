Clip audioClip = null;

public static void startSoundLoop(String name){
    try
        {
        clip = AudioSystem.getClip();
        this.audioClip = clip
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File((name)));
        File file = new File(name);
        inputStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();

        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
        }
            catch(Exception e)
            {
                System.out.println("Error: Can't locate sound.");
                e.printStackTrace();
            }
}

public static void stopSoundLoop{
    this.clip.stop();
}
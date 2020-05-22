private Audio mistakeAudio;

{
    mistakeAudio = Audio.createIfSupported();
    mistakeAudio.setSrc("style/failure.wav");
}

public void mistakeSound(){
    mistakeAudio.play();
}
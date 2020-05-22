//initialize this at the beginning of your program
AudioInputStream soundStream = AudioSystem.getAudioInputStream(new File("sound.wav"));

Clip soundEffect = AudioSystem.getClip();
soundEffect.open(soundStream);

...

//later, play the sound
soundEffect.start();
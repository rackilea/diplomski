URL soundResource;
if(RandomSongNum){
    soundResource = this.getClass().getClassLoader().getResource("BH-Lightest.wav");
} else {
    soundResource = this.getClass().getClassLoader().getResource("RY-Lightest.wav");
}
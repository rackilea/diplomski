//from your activity

AudioService audioService = new AudioService;
int randomTune = audioService.getRandom();
MediaPlayer mediaPlayer = MediaPlayer.create(context, randomTune);
mediaplayer.start;

//From a seperate service class

Class AudioService {

    private int[] audioFiles = {
        R.raw.song1, R.raw.song2, R.raw.song3, R.raw.song4, R.raw.song5, R.raw.song6
    };
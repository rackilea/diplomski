@Subscribe
public void handlePlaybackEvent(PlaybackEvent event) {
    switch (event) {
        case PLAY:
           if(MP1.isPlaying())
             MP1.pause();
            break;
        case PAUSE:
            if(!MP1.isPlaying())
             MP1.play();
            break;
    }
}
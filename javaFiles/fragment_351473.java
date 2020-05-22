package soundSystem;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

private Clip[] clip;
private boolean isPlaying;
private boolean loop;
private int maxC;
private int c;

public Sound(boolean loop, String file, int nrReplications){
    this.loop = loop;
    maxC = nrReplications;
    c = 0;
    clip = new Clip[maxC];
    try {
        int i = 0;
        while(i < maxC){
            clip[i] = AudioSystem.getClip();
            URL url = getClass().getResource(file);
            AudioInputStream input = AudioSystem.getAudioInputStream(url);
            clip[i].open(input);
            ++i;
        }
    }  catch (Exception e) {
        e.printStackTrace();
    }
}

public boolean getIsPlaying(){
    return isPlaying;
}

public void play(){
    if(clip == null ) return;
    if(c == maxC)
        c = 0;
    clip[c].stop();
    //clip.flush();
    clip[c].setMicrosecondPosition(0);
    //clip.setFramePosition(0);
    clip[c].start();
    ++c;
}

public void close(){
    clip[c].stop();
    clip[c].close();
}

public void update(){
    isPlaying = clip[0].isRunning();
    if(!isPlaying){
        if(loop)
            play();
        else 
            clip[0].stop();
    } 
}
}
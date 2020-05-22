import java.util.Arrays;

import org.jaudiolibs.beads.AudioServerIO;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.core.AudioIO;
import net.beadsproject.beads.core.UGen;
import net.beadsproject.beads.ugens.Gain;
import processing.core.PApplet;


public class BeadsJNA extends PApplet {

    AudioContext ac;

    public void setup(){
        ac = new AudioContext(new AudioServerIO.Jack(),512,AudioContext.defaultAudioFormat(4,2));//control number of ins(4) and outs(2)

        UGen microphoneIn = ac.getAudioInput();
        Gain g = new Gain(ac, 1, 0.5f);
        g.addInput(microphoneIn);
        ac.out.addInput(g);

        println("no. of inputs:  " + ac.getAudioInput().getOuts()); 

        ac.start();
    }
    public void draw(){
        loadPixels();
      Arrays.fill(pixels, color(0));

      for(int i = 0; i < width; i++)
      {
        int buffIndex = i * ac.getBufferSize() / width;
        int vOffset = (int)((1 + ac.out.getValue(0, buffIndex)) * height / 2);
        pixels[vOffset * height + i] = color(255);
      }
      updatePixels(); 
    }

    public static void main(String[] args) {
        PApplet.main(BeadsJNA.class.getSimpleName());
    }

}
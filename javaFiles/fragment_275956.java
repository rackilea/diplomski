import java.applet.*;
import java.awt.*;
import java.net.*;
/*
<applet code="Showimage" width = 400 height = 400>
</applet>
*/
public class Showimage extends Applet
{
    URL codb;
    Image picture;
    AudioClip clip;

    public void init()
    {
        picture = getImage(getCodeBase(), "../images/Beagle.jpg");

        clip  = getAudioClip(getDocumentBase(), "sound/woof.wav");
    }

    public String getAppletInfo()
    {
        return "Hi...";
    }

    public void start() { 
        clip.play();
        showStatus(getAppletInfo());
    }

    public void paint(Graphics g)
    {
        g.drawImage(picture, 10, 10, this);
    }
}
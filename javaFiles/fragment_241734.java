import java.awt.*;
import javax.swing.JOptionPane;

//retrieve the default sound from windows system sounds
//for another sound replace "default" accordingly
    final Runnable SOUND = (Runnable)Toolkit.getDefaultToolkit().getDesktopProperty
    ("win.sound.default");
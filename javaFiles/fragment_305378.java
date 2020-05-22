import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.Date;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;


/**
 * Simple demo on how a translucent window
 * looks like when is used to display the system clock.
 * @author <a href="http://stackoverflow.com/users/20654/oscarryz">Oscar Reyes</a>
 */
class Translucent extends JPanel implements ActionListener {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private final Date now = new Date();
    private final Timer timer = new Timer(1000, this);
    private final JLabel text = new JLabel();

    public Translucent() {
        super(true);
        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        now.setTime(System.currentTimeMillis());
        text.setText(String.format("<html><body><font size='50'>%s</font></body></html>",sdf.format(now)));
    }

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setUndecorated(true);
        setTranslucency(f);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(new Color(0f, 0f, 0f, 1f / 3f));
        JPanel p =  new Translucent();
        JLabel l = new JLabel("Hola");
        l.setFont(new Font(l.getFont().getName(), Font.PLAIN, 128));
        p.add(l);
        f.add(p);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    // taken from: http://java.sun.com/developer/technicalArticles/GUI/translucent_shaped_windows/
    private static void setTranslucency( Window window){
        try {
               Class<?> awtUtilitiesClass = Class.forName("com.sun.awt.AWTUtilities");
               Method mSetWindowOpacity = awtUtilitiesClass.getMethod("setWindowOpacity", Window.class, float.class);
               if (!mSetWindowOpacity.isAccessible()) {
                   mSetWindowOpacity.setAccessible(true);
               }
               mSetWindowOpacity.invoke(null, window, Float.valueOf(0.75f));
            } catch (NoSuchMethodException ex) {
               ex.printStackTrace();
            } catch (SecurityException ex) {
               ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
               ex.printStackTrace();
            } catch (IllegalAccessException ex) {
               ex.printStackTrace();
            } catch (IllegalArgumentException ex) {
               ex.printStackTrace();
            } catch (InvocationTargetException ex) {
               ex.printStackTrace();
            }
    }
}
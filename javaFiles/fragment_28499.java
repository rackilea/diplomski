import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

public class OpenGLMain implements GLEventListener { 

    private static FPSAnimator animator;
    private static int width;
    private static int height;
    private static GL2 gl;
    public static Rectangle screenSize;
    public static JFrame frame;

    public static void main(String[] args) {
        GLProfile glprofile = GLProfile.getMaximum(true);
        GLCapabilities capabilities = new GLCapabilities(glprofile);
        GLCanvas canvas = new GLCanvas(capabilities);

        screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        width = (int) screenSize.getWidth();
        height = (int) screenSize.getHeight();

        frame = new JFrame("Frame name");
        frame.setAlwaysOnTop(false);
        frame.setSize(width, height);
        frame.add(canvas);
        frame.setUndecorated(true);
        frame.setVisible(true);

        animator = new FPSAnimator(25);
        animator.add(canvas);
        animator.start();

        canvas.addGLEventListener(new OpenGLMain());
        canvas.requestFocus();

        Listeners.keyClicks(canvas);
        Listeners.mouseMovement(canvas);
        Listeners.mouseClicks(canvas);
        Listeners.mouseScrolled(canvas);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void display(GLAutoDrawable drawable) {
        update();
        render(drawable);
    }

    public void dispose(GLAutoDrawable drawable) {
    }

    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        Scenes.init(drawable, gl);
    }

    public void reshape(GLAutoDrawable drawable, int arg1, int arg2, int arg3, int arg4) {
    }

    private void update() {
        Scenes.update();
    }

    private void render(GLAutoDrawable drawable) {
        Scenes.render(drawable);
    }
}
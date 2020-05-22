import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.sun.opengl.util.Animator;
import java.awt.BorderLayout;

public class Jojl extends GLCanvas implements GLEventListener {

    static final long serialVersionUID = 4262202874615600756L;

    public static void main(String[] args) {
        Jojl convas = new Jojl();
        Animator animator = new Animator(convas);
        JFrame jframe = new JFrame("hello JOGL");
        jframe.setVisible(true);
        jframe.setSize(500, 500);
        jframe.setVisible(true);
        jframe.setLayout(null);
        JPanel jp = new JPanel(new BorderLayout()); // 1.              <- HERE
        jp.setSize(jframe.getSize());
        jframe.add(jp);
        // jp.setBackground(Color.BLUE); // 2. rather do that in JOGL
        jp.add(convas);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        animator.start();

    }

    public Jojl() {
        super(new GLCapabilities());
        addGLEventListener(this);  // 2.                              <-- HERE
    }

    @Override
    public void display(GLAutoDrawable arg0) {
        System.out.println("hello");
        GL gl = arg0.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glRectf(-0.5f, -0.5f, 0.5f, 0.5f);
    }

    @Override
    public void displayChanged(GLAutoDrawable arg0,
            boolean arg1, boolean arg2) {}

    @Override
    public void init(GLAutoDrawable arg0) {}

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
            int arg4) {}
}
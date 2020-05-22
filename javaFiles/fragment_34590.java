package com.cogwheel.framework.graphics;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import com.jogamp.opengl.util.Animator;

public class CWGOpenGLScreen extends JFrame implements GLEventListener {

    public static void main(String[] args) {
        new CWGOpenGLScreen().setVisible(true);
    }

private static final long serialVersionUID = 635066680731362587L;

private static final String TAG = "CWGOpenGLScreen";

private GLCanvas mCanvas;
private long fpsLast = System.currentTimeMillis();

public CWGOpenGLScreen(){
    this.setTitle(TAG);
    this.setSize(640,480);
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ///this.setResizable(false);

    CWGSetupGL();
    this.setVisible(true);

//    CWGDebug.info(TAG, "Window created!");
}
private void CWGSetupGL(){
    GLCapabilities mCaps = new GLCapabilities(null);
    mCaps.setHardwareAccelerated(true);
    mCaps.setDoubleBuffered(true);

    mCanvas = new GLCanvas(mCaps);
    mCanvas.addGLEventListener(this);

    this.add(mCanvas, BorderLayout.CENTER);

    final Animator animator = new Animator(mCanvas);
    animator.start();

    addWindowListener(new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            animator.stop();
            System.exit(0);
        }



    });
}

public void CWGDrawScene(GLAutoDrawable drawable)
{
    CWGCalculateFPS();

    GL2 gl = drawable.getGL().getGL2();
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    gl.glLoadIdentity();


    gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f / 5 , 0.0f, 0.0f);

        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f / 5, 1.0f / 5, 0.0f);

        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f / 5, 1.0f / 5);
    gl.glEnd();
    gl.glFlush();
}

public void CWGCalculateFPS(){
    this.setTitle(TAG + " [" + 1000 / (System.currentTimeMillis() - fpsLast) + "]");
    fpsLast = System.currentTimeMillis();
}

public void init(GLAutoDrawable drawable){
        /*GL2 gl = drawable.getGL().getGL2();

        gl.glClearColor(0, 0, 0, 0);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0, 1, 0, 1, -1, 1);
        */
//        CWGDebug.info(TAG, "Init called!");
}
public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height){
    GL2 gl = drawable.getGL().getGL2();
    gl.glViewport(x, y, width, height);
}
//public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged){}
public void display(GLAutoDrawable drawable){ CWGDrawScene(drawable); }
public void dispose(GLAutoDrawable drawable){}
}
import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

/**
 * Test developed using:
 * 
 * A minimal JOGL demo.
 * 
 * @author <a href="mailto:kain@land-of-kain.de">Kai Ruhl</a>
 * @since 26 Feb 2009
 */
public class test3d extends GLCanvas implements GLEventListener {

    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The GL unit (helper class). */
    private GLU glu;

    /** The frames per second setting. */
    private int fps = 24;

    /** The OpenGL animator. */
    private FPSAnimator animator;

    /** The earth texture. */
    private Texture earthTexture;

    private int see_ = 0;

    /**
     * A new mini starter.
     */
    public test3d(int see) {
        addGLEventListener(this);
        see_ = see;
    }

    /**
     * Sets up the screen.
     * 
     * @see javax.media.opengl.GLEventListener#init(javax.media.opengl.GLAutoDrawable)
     */
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = (GL2) drawable.getGL();

        // Enable z- (depth) buffer for hidden surface removal. 
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);

        // Enable smooth shading.
        gl.glShadeModel(GL2.GL_SMOOTH);

        // Define "clear" color.
        gl.glClearColor(0f, 0f, 0f, 0f);

        // We want a nice perspective.
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);

        // Create GLU.
        glu = new GLU();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        // Load earth texture.
        try {
            FileInputStream stream = new FileInputStream(ROUTE TO IMAGE);
            TextureData data = TextureIO.newTextureData(profile, stream, false, "png");
            earthTexture = TextureIO.newTexture(data);
        }
        catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }

        // Start animator.
        animator = new FPSAnimator(this, fps);
        animator.start();
    }

    /**
     * The only method that you should implement by yourself.
     * 
     * @see javax.media.opengl.GLEventListener#display(javax.media.opengl.GLAutoDrawable)
     */
    public void display(GLAutoDrawable drawable) {
        if (!animator.isAnimating()) {
            return;
        }
        final GL2 gl = (GL2) drawable.getGL();

        // Clear screen.
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

        // Set camera.
        setCamera(gl, glu, 30);

        // Prepare light parameters.
        float SHINE_ALL_DIRECTIONS = 1;
        float[] lightPos = {0, 0, 0, SHINE_ALL_DIRECTIONS};
        float[] lightColorAmbient = {1f, 1f, 1f, 1f};
        float[] lightColorSpecular = {1f, 1f, 1f, 1f};

        // Set light parameters.
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_POSITION, lightPos, 0);
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_AMBIENT, lightColorAmbient, 0);
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_SPECULAR, lightColorSpecular, 0);

        // Enable lighting in GL.
        gl.glEnable(GL2.GL_LIGHT1);
        gl.glEnable(GL2.GL_LIGHTING);

        // Set material properties.
        float[] rgba = {1f, 0f, 0f};
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, 1f);

        gl.glBegin(gl.GL_LINES);        //RED == X
            gl.glVertex3f(0, 0, 0);
            gl.glVertex3f(10, 0, 0);
        gl.glEnd();

        rgba[0] = 0f;
        rgba[1] = 1f;
        rgba[2] = 0f;
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, 1f);

        gl.glBegin(gl.GL_LINES);        //GREEN == Y
            gl.glVertex3f(0, 0, 0);
            gl.glVertex3f(0, 10, 0);
        gl.glEnd();


        rgba[0] = 0f;
        rgba[1] = 0f;
        rgba[2] = 1f;
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, 1f);
        gl.glBegin(gl.GL_LINES);        //BLUE == Z
            gl.glVertex3f(0, 0, 0);
            gl.glVertex3f(0, 0, 10);
        gl.glEnd();     

        // Set material properties.
        float theta = 45f;
        float phi = 270f;
        /*
        ////////////////////////////////////////////////////LINES 1 ROT//////////////////////////////////////////////////////////
        gl.glPushMatrix();
        gl.glLoadIdentity();            //I reset the matrix. Now the translation and rotation is from the origin (0,0,0)
        rgba[0] = 1f;
        rgba[1] = 0f;
        rgba[2] = 1f;
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, 1f);

        gl.glRotatef(phi, 0, 0, 1);

        gl.glBegin(gl.GL_LINES);        //VIOLET == X'
            gl.glVertex3f(0, 0, 0);
            gl.glVertex3f(10, 0, 0);
        gl.glEnd();

        gl.glPopMatrix();


        gl.glPushMatrix();
        gl.glLoadIdentity();            //I reset the matrix. Now the translation and rotation is from the origin (0,0,0)
        rgba[0] = 1f;
        rgba[1] = 1f;
        rgba[2] = 0f;
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, 1f);

        gl.glRotatef(phi, 0, 0, 1);

        gl.glBegin(gl.GL_LINES);        //YELLOW == Y'
            gl.glVertex3f(0, 0, 0);
            gl.glVertex3f(0, 10, 0);
        gl.glEnd();

        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glLoadIdentity();            //I reset the matrix. Now the translation and rotation is from the origin (0,0,0)
        rgba[0] = 0f;
        rgba[1] = 1f;
        rgba[2] = 1f;
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, 1f); 

        gl.glRotatef(phi, 0, 0, 1);

        gl.glBegin(gl.GL_LINES);        //CYAN == Z'
            gl.glVertex3f(0, 0, 0);
            gl.glVertex3f(0, 0, 10);
        gl.glEnd();     

        gl.glPopMatrix();
        */

        gl.glPushMatrix();
        gl.glLoadIdentity();            //I reset the matrix. Now the translation and rotation is from the origin (0,0,0)
        rgba[0] = 1f;
        rgba[1] = 1f;
        rgba[2] = 1f;
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, 1f); 

        //gl.glRotatef(theta, (float) Math.sin(phi), (float) Math.cos(phi), 0);
        gl.glTranslatef(3, 0, 0);
        gl.glRotatef(theta, 0, 1, 0);
        gl.glRotatef(phi, 0, 0, 1);
        gl.glBegin(gl.GL_LINES);        //WHITE == NEW Y'
            gl.glVertex3f(0, 0, 0);
            gl.glVertex3f(0, 0, 10.f);
        gl.glEnd();

        gl.glPopMatrix();


        ////////////////////////////////////////////////////LINES 2 ROT//////////////////////////////////////////////////////////
        gl.glPushMatrix();
        gl.glLoadIdentity();            //I reset the matrix. Now the translation and rotation is from the origin (0,0,0)
        rgba[0] = 1f;
        rgba[1] = 0f;
        rgba[2] = 1f;
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, 1f);

        //gl.glRotatef(theta, (float) -Math.sin(phi), (float) Math.cos(phi),0); 
        //gl.glRotatef(theta, (float) Math.sin(phi*Math.PI/180), (float) Math.cos(phi*Math.PI/180),0);    
        gl.glRotatef(theta, 0, 1, 0);
        gl.glRotatef(phi, 0, 0, 1);

        gl.glBegin(gl.GL_LINES);        //VIOLET == X'
            gl.glVertex3f(0, 0, 0);
            gl.glVertex3f(10, 0, 0);
        gl.glEnd();

        gl.glPopMatrix();


        gl.glPushMatrix();
        gl.glLoadIdentity();            //I reset the matrix. Now the translation and rotation is from the origin (0,0,0)
        rgba[0] = 1f;
        rgba[1] = 1f;
        rgba[2] = 0f;
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, 1f);

        //gl.glRotatef(theta, (float) -Math.sin(phi), (float) Math.cos(phi),0); 
        //gl.glRotatef(theta, (float) Math.sin(phi*Math.PI/180), (float) Math.cos(phi*Math.PI/180),0);    
        gl.glRotatef(theta, 0, 1, 0);
        gl.glRotatef(phi, 0, 0, 1);

        gl.glBegin(gl.GL_LINES);        //YELLOW == Y'
            gl.glVertex3f(0, 0, 0);
            gl.glVertex3f(0, 10, 0);
        gl.glEnd();

        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glLoadIdentity();            //I reset the matrix. Now the translation and rotation is from the origin (0,0,0)
        rgba[0] = 0f;
        rgba[1] = 1f;
        rgba[2] = 1f;
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, 1f); 

        //gl.glRotatef(theta, (float) -Math.sin(phi), (float) Math.cos(phi),0); 
        //gl.glRotatef(theta, (float) Math.sin(phi*Math.PI/180), (float) Math.cos(phi*Math.PI/180),0); 
        gl.glRotatef(theta, 0, 1, 0);
        gl.glRotatef(phi, 0, 0, 1);

        gl.glBegin(gl.GL_LINES);        //CYAN == Z'
            gl.glVertex3f(0, 0, 0);
            gl.glVertex3f(0, 0, 10);
        gl.glEnd();     

        gl.glPopMatrix();

        //////////////////////////////////////////SPHERES////////////////////////////////////////////

        // Apply texture.

        rgba[0] = 1f;
        rgba[1] = 1f;
        rgba[2] = 1f;
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, 1f);

        earthTexture.enable(gl);
        earthTexture.bind(gl);

        gl.glPushMatrix();
        gl.glLoadIdentity();            //I reset the matrix. Now the translation and rotation is from the origin (0,0,0)

        GLUquadric earth = glu.gluNewQuadric();
        glu.gluQuadricTexture(earth, true);
        glu.gluQuadricDrawStyle(earth, GLU.GLU_FILL);
        glu.gluQuadricNormals(earth, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(earth, GLU.GLU_OUTSIDE);          
        glu.gluSphere(earth, 0.5, 64, 64);        
        glu.gluDeleteQuadric(earth);
        gl.glPopMatrix();

        earthTexture.disable(gl);

        earthTexture.enable(gl);
        earthTexture.bind(gl);



        gl.glPushMatrix();
        gl.glLoadIdentity();            //I reset the matrix. Now the translation and rotation is from the origin (0,0,0)
        gl.glTranslatef(1.5f, 0, 0);    
        gl.glRotatef(phi, 0,0,1);

        GLUquadric earth1 = glu.gluNewQuadric();
        glu.gluQuadricTexture(earth1, true);
        glu.gluQuadricDrawStyle(earth1, GLU.GLU_FILL);
        glu.gluQuadricNormals(earth1, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(earth1, GLU.GLU_OUTSIDE);         
        glu.gluSphere(earth1, 0.5, 64, 64);        
        glu.gluDeleteQuadric(earth1);
        gl.glPopMatrix();

        earthTexture.disable(gl);

        earthTexture.enable(gl);
        earthTexture.bind(gl);

        gl.glPushMatrix();
        gl.glLoadIdentity();            //I reset the matrix. Now the translation and rotation is from the origin (0,0,0)
        gl.glTranslatef(3.f, 0, 0);         
        gl.glRotatef(theta, 0, 1,0);    
        gl.glRotatef(phi, 0,0,1);

        GLUquadric earth2 = glu.gluNewQuadric();
        glu.gluQuadricTexture(earth2, true);
        glu.gluQuadricDrawStyle(earth2, GLU.GLU_FILL);
        glu.gluQuadricNormals(earth2, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(earth2, GLU.GLU_OUTSIDE);         
        glu.gluSphere(earth2, 0.5, 64, 64);        
        glu.gluDeleteQuadric(earth2);
        gl.glPopMatrix();

        earthTexture.disable(gl);
    }

    /**
     * Resizes the screen.
     * 
     * @see javax.media.opengl.GLEventListener#reshape(javax.media.opengl.GLAutoDrawable,
     *      int, int, int, int)
     */
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL gl = drawable.getGL();
        gl.glViewport(0, 0, width, height);
    }

    /**
     * Changing devices is not supported.
     * 
     * @see javax.media.opengl.GLEventListener#displayChanged(javax.media.opengl.GLAutoDrawable,
     *      boolean, boolean)
     */
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        throw new UnsupportedOperationException("Changing display is not supported.");
    }

    /**
     * @param gl The GL context.
     * @param glu The GL unit.
     * @param distance The distance from the screen.
     */
    private void setCamera(GL2 gl, GLU glu, float distance) {
        // Change to projection matrix.
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        // Perspective.
        float widthHeightRatio = (float) getWidth() / (float) getHeight();
        glu.gluPerspective(45, widthHeightRatio, 1, 10000);
        if (see_ == 0){
            glu.gluLookAt(10, 10, 10, 0, 0, 0, 0, 0, 1);        
        }else if (see_ == 1){
            glu.gluLookAt(10, 0, 0, 0, 0, 0, 0, 0, 1);      
        }else if (see_ == 2){
            glu.gluLookAt(0, 10, 0, 0, 0, 0, 0, 0, 1);     
        }else if (see_ == 3){
            glu.gluLookAt(0, 0, 10, 0, 0, 0, 0, 1, 0);     
        }
        // Change back to model view matrix.
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    /**
     * Starts the JOGL mini demo.
     * 
     * @param args Command line args.
     */
    public final static void main(String[] args) {
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        capabilities.setRedBits(8);
        capabilities.setBlueBits(8);
        capabilities.setGreenBits(8);
        capabilities.setAlphaBits(8);         

        int size = 640;

        test3d canvas = new test3d(0);        
        JFrame frame = new JFrame("Mini JOGL Demo (breed)");
        frame.getContentPane().add(canvas, BorderLayout.CENTER);
        frame.setBounds(0, 200, size, size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        test3d canvas2 = new test3d(1);        
        JFrame frame2 = new JFrame("Mini JOGL Demo (breed)");
        frame2.getContentPane().add(canvas2, BorderLayout.CENTER);
        frame2.setBounds(0, 200, size, size);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);

        test3d canvas3 = new test3d(2);        
        JFrame frame3 = new JFrame("Mini JOGL Demo (breed)");
        frame3.getContentPane().add(canvas3, BorderLayout.CENTER);
        frame3.setBounds(0, 200, size, size);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);

        test3d canvas4 = new test3d(3);        
        JFrame frame4 = new JFrame("Mini JOGL Demo (breed)");
        frame4.getContentPane().add(canvas4, BorderLayout.CENTER);
        frame4.setBounds(0, 200, size, size);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(true);

    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub

    }

}
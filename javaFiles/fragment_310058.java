package at.bartinger.opengl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.util.AttributeSet;

public class GLGameView extends GLSurfaceView implements GLSurfaceView.Renderer{


public GLGameView(Context context) {
    super(context);
    setRenderer(this);
}

public GLGameView(Context context, AttributeSet attrs) {
    super(context, attrs);
    // TODO Auto-generated constructor stub
}

@Override
public void onSurfaceCreated(GL10 gl, EGLConfig config) {
    init(gl);
}

@Override
public void onDrawFrame(GL10 gl) {

    //Standard
    gl.glClear( GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT );
    gl.glViewport( 0, 0, getWidth(), getHeight() );

    gl.glDisable( GL10.GL_DITHER );
    gl.glEnable( GL10.GL_DEPTH_TEST );
    gl.glEnable( GL10.GL_CULL_FACE );

    //Set 3D
    gl.glMatrixMode( GL10.GL_PROJECTION );
    gl.glLoadIdentity();
    gluPerspective( gl);    



    draw3D(gl);


    gl.glDisable( GL10.GL_CULL_FACE );
    gl.glDisable( GL10.GL_DEPTH_TEST );

    //Set 2D
    gl.glMatrixMode( GL10.GL_PROJECTION );
    gl.glLoadIdentity();
    gluOrtho2D(gl);
    gl.glMatrixMode( GL10.GL_MODELVIEW );
    gl.glLoadIdentity();


    draw2D(gl);

}

@Override
public void onSurfaceChanged(GL10 gl, int width, int height) {

}

public void init(GL10 gl){}

public void draw2D(GL10 gl){};

public void draw3D(GL10 gl){};

/**
 * Sets the projection to the ortho matrix
 */
public void gluOrtho2D(GL10 gl){
    gl.glMatrixMode( GL10.GL_PROJECTION );
    gl.glLoadIdentity();
    GLU.gluOrtho2D( gl, 0, getWidth(), 0, getHeight() );
}

/**
 * Sets the projection to the perspective matrix
 */
public void gluPerspective(GL10 gl){
    gl.glMatrixMode( GL10.GL_PROJECTION );
    gl.glLoadIdentity();
    float aspectRatio = (float)getWidth() / getHeight();
    GLU.gluPerspective( gl, 67, aspectRatio, 1, 100 );
}

/**
 * Sets the projection to the perspective matrix
 */
public void gluPerspective(GL10 gl, float near, float far){
    gl.glMatrixMode( GL10.GL_PROJECTION );
    gl.glLoadIdentity();
    float aspectRatio = (float)getWidth() / getHeight();
    GLU.gluPerspective( gl, 67, aspectRatio, near, far );
}

/**
 * Sets the projection to the model view matrix
 */
public void gluLookAt(GL10 gl, 
        float positionX, float positionY, float positionZ,
        float zentrumX, float zentrumY, float zentrumZ,
        float upX, float upY, float upZ ){

    gl.glMatrixMode( GL10.GL_MODELVIEW );
    gl.glLoadIdentity();
    GLU.gluLookAt( gl,positionX, positionY, positionZ, zentrumX, zentrumY, zentrumZ, upX, upY, upZ );
    }
}
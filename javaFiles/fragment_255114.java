package com.example.gphspc.javacvtest;

import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.view.ViewGroup;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class BitmapRenderer implements GLSurfaceView.Renderer {

    private int[] textures;
    private Bitmap bitmap;
    private GLSurfaceView glSurfaceView;
    private int parentWidth, parentHeight;
    private boolean sizeModified = false;

    public BitmapRenderer(GLSurfaceView glSurfaceView) {
        this.glSurfaceView = glSurfaceView;
        this.glSurfaceView.setEGLContextClientVersion(1);
        this.glSurfaceView.setRenderer(this);
        this.glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    private static final float[] VERTEX_COORDINATES = new float[]{
            -1.0f, +1.0f, 0.0f,
            +1.0f, +1.0f, 0.0f,
            -1.0f, -1.0f, 0.0f,
            +1.0f, -1.0f, 0.0f
    };

    private static final float[] TEXTURE_COORDINATES = new float[]{
            0.0f, 0.0f,
            1.0f, 0.0f,
            0.0f, 1.0f,
            1.0f, 1.0f
    };

    private static final Buffer TEXCOORD_BUFFER = ByteBuffer.allocateDirect(TEXTURE_COORDINATES.length * 4)
            .order(ByteOrder.nativeOrder()).asFloatBuffer().put(TEXTURE_COORDINATES).rewind();
    private static final Buffer VERTEX_BUFFER = ByteBuffer.allocateDirect(VERTEX_COORDINATES.length * 4)
            .order(ByteOrder.nativeOrder()).asFloatBuffer().put(VERTEX_COORDINATES).rewind();

    public void draw(Bitmap bitmap) {
        if (bitmap == null)
            return;

        this.bitmap = bitmap;

        if (!sizeModified) {
            ViewGroup.LayoutParams layoutParams = glSurfaceView.getLayoutParams();
            Dimension newDims = getRelativeSize(new Dimension(bitmap.getWidth(), bitmap.getHeight()), glSurfaceView.getWidth(), glSurfaceView.getHeight());
            layoutParams.width = newDims.getWidth();
            layoutParams.height = newDims.getHeight();
            glSurfaceView.setLayoutParams(layoutParams);
            sizeModified = true;
        }

        glSurfaceView.requestRender();
    }

    public static Dimension getRelativeSize(Dimension dimension, int width, int height) {
        int toWidth = width, toHeight = height;

        int imgWidth = (int) dimension.getWidth();
        int imgHeight = (int) dimension.getHeight();

        if (imgWidth > imgHeight) {
            toWidth = (int) ((double) height / ((double) imgHeight / imgWidth));
            if (toWidth > width)
                toWidth = width;
            toHeight = (int) (toWidth * ((double) imgHeight / imgWidth));
        } else if (imgWidth < imgHeight) {
            toHeight = (int) ((double) width / ((double) imgWidth / imgHeight));
            if (toHeight > height)
                toHeight = height;
            toWidth = (int) (toHeight * ((double) imgWidth / imgHeight));
        }

        return new Dimension(toWidth, toHeight);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        textures = new int[1];
        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

        ViewGroup.LayoutParams layoutParams = glSurfaceView.getLayoutParams();
        parentWidth = layoutParams.width;
        parentHeight = layoutParams.height;
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
//        gl.glOrthof(0f, width, 0f, height, -1f, 1f);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        if (bitmap != null) {

            gl.glGenTextures(1, textures, 0);
            gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);

            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_CLAMP_TO_EDGE);
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_CLAMP_TO_EDGE);

            GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);

            gl.glActiveTexture(GL10.GL_TEXTURE0);
            gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);

            gl.glVertexPointer(3, GL10.GL_FLOAT, 0, VERTEX_BUFFER);
            gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, TEXCOORD_BUFFER);
            gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        }
    }
}

class Dimension {
    int width = 0, height = 0;

    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
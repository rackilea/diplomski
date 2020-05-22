import com.sun.opengl.util.*;

import javax.media.opengl.*;
import javax.swing.*;
import java.nio.*;


public class VBOTest implements GLEventListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new VBOTest());
        frame.add(canvas);
        frame.setSize(640, 480);
        frame.setVisible(true);
    }

    private FloatBuffer vertices;
    private ShortBuffer indices;
    private int VBOVertices;
    private int VBOIndices;

    public void init(GLAutoDrawable drawable) {
        float[] vertexArray = {-0.5f,  0.5f, 0,
                                0.5f,  0.5f, 0,
                                0.5f, -0.5f, 0,
                               -0.5f, -0.5f, 0};
        vertices = BufferUtil.newFloatBuffer(vertexArray.length);
        vertices.put(vertexArray);
        vertices.flip();

        short[] indexArray = {0, 1, 2, 0, 2, 3};
        indices = BufferUtil.newShortBuffer(indexArray.length);
        indices.put(indexArray);
        indices.flip();

        GL gl = drawable.getGL();
        int[] temp = new int[2];
        gl.glGenBuffers(2, temp, 0);

        VBOVertices = temp[0];
        gl.glBindBuffer(GL.GL_ARRAY_BUFFER, VBOVertices);
        gl.glBufferData(GL.GL_ARRAY_BUFFER, vertices.capacity() * BufferUtil.SIZEOF_FLOAT,
                            vertices, GL.GL_STATIC_DRAW);
        gl.glBindBuffer(GL.GL_ARRAY_BUFFER, 0);

        VBOIndices = temp[1];
        gl.glBindBuffer(GL.GL_ELEMENT_ARRAY_BUFFER, VBOIndices);
        gl.glBufferData(GL.GL_ELEMENT_ARRAY_BUFFER, indices.capacity() * BufferUtil.SIZEOF_SHORT,
                            indices, GL.GL_STATIC_DRAW);
        gl.glBindBuffer(GL.GL_ELEMENT_ARRAY_BUFFER, 0);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        gl.glEnableClientState(GL.GL_VERTEX_ARRAY);

        gl.glBindBuffer(GL.GL_ARRAY_BUFFER, VBOVertices);
        gl.glVertexPointer(3, GL.GL_FLOAT, 0, 0);
        gl.glBindBuffer(GL.GL_ELEMENT_ARRAY_BUFFER, VBOIndices);
        gl.glDrawElements(GL.GL_TRIANGLES, indices.capacity(), GL.GL_UNSIGNED_SHORT, 0);

        gl.glDisableClientState(GL.GL_VERTEX_ARRAY);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {}
}
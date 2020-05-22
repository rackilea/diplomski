glcanvas.addGLEventListener(new GLEventListener() {
    @Override
    public void reshape(GLAutoDrawable glautodrawable, int x, int y, int width, int height) {
        GL2 gl = glautodrawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity(); // Resets any previous projection matrices
        gl.glOrtho(0, width, 0, height, 1, -1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }

    ... Other methods

}
gl.glVertexAttribPointer(0, 3, GL.GL_FLOAT, false, 8 * Float.BYTES, 0);
gl.glEnableVertexAttribArray(0);

gl.glVertexAttribPointer(1, 3, GL.GL_FLOAT, false, 8 * Float.BYTES, 3 * Float.BYTES);
gl.glEnableVertexAttribArray(1); // <-------

gl.glVertexAttribPointer(2, 2, GL.GL_FLOAT, false, 8 * Float.BYTES, 6 * Float.BYTES);
gl.glEnableVertexAttribArray(2); // <------
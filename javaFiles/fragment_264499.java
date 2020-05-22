// Somewhere in your class
private float [] verts;


// You can fill this with actual data yourself, I did the hard part :P
verts = new float [] { 0.0f, 0.0f, 0.0f, 1.0f,     0.0f, 0.0f, 0.0f, 1.0f,
                       0.0f, 0.0f, 0.0f, 1.0f,     0.0f, 0.0f, 0.0f, 1.0f,
                       0.0f, 0.0f, 0.0f, 1.0f,     0.0f, 0.0f, 0.0f, 1.0f,
                       0.0f, 0.0f, 0.0f, 1.0f,     0.0f, 0.0f, 0.0f, 1.0f };
                    // ^^^^^^^^^ POS ^^^^^^^^      ^^^^^^^ NORMAL ^^^^^^^

//
// When it comes time to supply the vertex pointers, use this:
//
FloatBuffer vtx_base  = FloatBuffer.wrap (verts);
FloatBuffer norm_base = FloatBuffer.wrap (verts, 4, verts.length () - 4);

gl.glVertexAttribPointer (POSITION_ATTRIB, 4, GL.GL_FLOAT, false, 32, vtx_base);
gl.glVertexAttribPointer (NORMAL_ATTRIB,   4, GL.GL_FLOAT, false, 32, norm_base);
// Misc
private Context mContext;

// Geometric variables
// number of coordinates per vertex in this array
private static final int COORDS_PER_VERTEX = 3;
private static float vertices[] = {
        10.0f, 300f, 0.0f,
        10.0f, 100f, 0.0f,
        450f, 100f, 0.0f,
        450f, 300f, 0.0f,
};
private static float vertices2[] = {
        450.0f, 600f, 0.0f,
        450.0f, 300f, 0.0f,
        900f, 300f, 0.0f,
        900f, 600f, 0.0f,
};

private final short indices[] = { 0, 1, 2, 0, 2, 3 }; // order to draw vertices
private static float uvs[] = {
        0.0f, 0.0f,
        0.0f, 1.0f,
        1.0f, 1.0f,
        1.0f, 0.0f
};
private FloatBuffer vertexBuffer;
private ShortBuffer drawListBuffer;
private FloatBuffer uvBuffer;


private final int vertexStride = COORDS_PER_VERTEX * 4; // 4 bytes per vertex

final int[] textureHandle;

public CardView(Context c, int index)
{

    textureHandle = new int[2];
    // Save context reference
    mContext = c;
    // Create the triangles
    SetupCard(index);
    // Create the image information
    SetupImage(index);

    // Set the clear color to black
    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1);

    // Create the shaders, solid color
    int vertexShader = riGraphicTools.loadShader(GLES20.GL_VERTEX_SHADER, riGraphicTools.vs_SolidColor);
    int fragmentShader = riGraphicTools.loadShader(GLES20.GL_FRAGMENT_SHADER, riGraphicTools.fs_SolidColor);

    riGraphicTools.sp_SolidColor = GLES20.glCreateProgram();             // create empty OpenGL ES Program
    GLES20.glAttachShader(riGraphicTools.sp_SolidColor, vertexShader);   // add the vertex shader to program
    GLES20.glAttachShader(riGraphicTools.sp_SolidColor, fragmentShader); // add the fragment shader to program
    GLES20.glLinkProgram(riGraphicTools.sp_SolidColor);                  // creates OpenGL ES program executables

    // Create the shaders, images
    vertexShader = riGraphicTools.loadShader(GLES20.GL_VERTEX_SHADER, riGraphicTools.vs_Image);
    fragmentShader = riGraphicTools.loadShader(GLES20.GL_FRAGMENT_SHADER, riGraphicTools.fs_Image);

    riGraphicTools.sp_Image = GLES20.glCreateProgram();             // create empty OpenGL ES Program
    GLES20.glAttachShader(riGraphicTools.sp_Image, vertexShader);   // add the vertex shader to program
    GLES20.glAttachShader(riGraphicTools.sp_Image, fragmentShader); // add the fragment shader to program
    GLES20.glLinkProgram(riGraphicTools.sp_Image);                  // creates OpenGL ES program executables


    // Set our shader programm
    GLES20.glUseProgram(riGraphicTools.sp_Image);
}



public void SetupImage(int index)
{

    GLES20.glGenTextures(2, textureHandle, 0);

    // The texture buffer
    ByteBuffer bb = ByteBuffer.allocateDirect(uvs.length * 4);
    bb.order(ByteOrder.nativeOrder());
    uvBuffer = bb.asFloatBuffer();
    uvBuffer.put(uvs);
    uvBuffer.position(0);

    // Generate Textures, if more needed, alter these numbers.
    int[] texturenames = new int[1];
    GLES20.glGenTextures(1, texturenames, 0);

    // Retrieve our image from resources.
    //int id = mContext.getResources().getIdentifier("drawable/test_backbground1", null, mContext.getPackageName());
    if(index == 1) {
        int id = riGraphicTools.loadTexture(mContext, R.drawable.test_backbground1, textureHandle, index);
    }else{
        int id = riGraphicTools.loadTexture(mContext, R.drawable.test_backbground2, textureHandle, index);
    }

}


public void SetupCard(int index)
{

    if( index == 1) {
        // The vertex buffer.
        ByteBuffer bb = ByteBuffer.allocateDirect(vertices.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
    }else{
        // The vertex buffer.
        ByteBuffer bb = ByteBuffer.allocateDirect(vertices2.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(vertices2);
        vertexBuffer.position(0);
    }

    // initialize byte buffer for the draw list
    ByteBuffer dlb = ByteBuffer.allocateDirect(indices.length * 2);
    dlb.order(ByteOrder.nativeOrder());
    drawListBuffer = dlb.asShortBuffer();
    drawListBuffer.put(indices);
    drawListBuffer.position(0);


}

/**
 * Encapsulates the OpenGL ES instructions for drawing this shape.
 *
 * @param mvpMatrix - The Model View Project matrix in which to draw
 * this shape.
 */

public void Draw(float[] mvpMatrix, int textureIndex){

    // clear Screen and Depth Buffer, we have set the clear color as black.
    //GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);


    GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
    GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureHandle[textureIndex]);

    // get handle to vertex shader's vPosition member
    int mPositionHandle = GLES20.glGetAttribLocation(riGraphicTools.sp_Image, "vPosition");

    // Enable generic vertex attribute array
    GLES20.glEnableVertexAttribArray(mPositionHandle);

    // Prepare the triangle coordinate data
    GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX,
            GLES20.GL_FLOAT, false,
            vertexStride, vertexBuffer);

    // Get handle to texture coordinates location
    int mTexCoordLoc = GLES20.glGetAttribLocation(riGraphicTools.sp_Image, "a_texCoord" );

    // Enable generic vertex attribute array
    GLES20.glEnableVertexAttribArray ( mTexCoordLoc );

    // Prepare the texturecoordinates
    GLES20.glVertexAttribPointer ( mTexCoordLoc, 2, GLES20.GL_FLOAT,
            false,
            0, uvBuffer);

    // Get handle to shape's transformation matrix
    int mtrxhandle = GLES20.glGetUniformLocation(riGraphicTools.sp_Image, "uMVPMatrix");

    // Apply the projection and view transformation
    GLES20.glUniformMatrix4fv(mtrxhandle, 1, false, mvpMatrix, 0);

    // Get handle to textures locations
    int mSamplerLoc = GLES20.glGetUniformLocation (riGraphicTools.sp_Image, "s_texture" );

    // Set the sampler texture unit to 0, where we have saved the texture.
    GLES20.glUniform1i ( mSamplerLoc, 0);

    // Draw the triangle
    GLES20.glDrawElements(GLES20.GL_TRIANGLES, indices.length,
            GLES20.GL_UNSIGNED_SHORT, drawListBuffer);

    // Disable vertex array
    GLES20.glDisableVertexAttribArray(mPositionHandle);
    GLES20.glDisableVertexAttribArray(mTexCoordLoc);

}
private int m_numRectangles;
private int m_nextRectIndex;

//initialize both above variables to 0

//...

if(Gdx.input.justTouched())
{
    m_nextRectIndex = m_numRectangles * 8;
    m_numRectangles++;

    //save a copy of the old rectangles
    vertexBuffer.rewind();
    Float[] oldRects = new Float[ vertexBuffer.remaining() ];
    vertexBuffer.get(oldRects);

    //allocate more memory for old + one more rectangle
    vertexBuffer = BufferUtils.newFloatBuffer( m_numRectangles * 8 );

    //copy back the old rectangles
    vertexBuffer.put( oldbuffer );
    vectexBuffer.rewind();

    position_x = Gdx.input.getX();
    position_y = screenHeight - Gdx.input.getY();

    vertexBuffer.put(m_nextRectIndex + 0, position_x - size_rect);
    vertexBuffer.put(m_nextRectIndex + 1, position_y - size_rect);
    vertexBuffer.put(m_nextRectIndex + 2, position_x - size_rect);
    vertexBuffer.put(m_nextRectIndex + 3, position_y + size_rect);
    vertexBuffer.put(m_nextRectIndex + 4, position_x + size_rect);
    vertexBuffer.put(m_nextRectIndex + 5, position_y - size_rect);
    vertexBuffer.put(m_nextRectIndex + 6, position_x + size_rect);
    vertexBuffer.put(m_nextRectIndex + 7, position_y + size_rect);

}
Gdx.gl.glVertexAttribPointer(positionLoc, 2, GL20.GL_FLOAT, false, 0, vertexBuffer);
for( int i=0; i<m_numRectangles * 4; i+=4 )
{
    Gdx.gl.glDrawArrays(GL20.GL_TRIANGLE_STRIP, i, 4);
}
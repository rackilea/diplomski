public boolean SaveFrameBuffer(int x, int y)
{   try
    {   IntBuffer   pinbuffer   = IntBuffer.allocate(x*y*4);
        IntBuffer   poutbuffer  = IntBuffer.allocate(x*y*4);
        int         i,j,z;
        int []      pin         = pinbuffer.array();
        int []      pout        = poutbuffer.array();
        //
        GLES20.glReadPixels(0, 0, x, y, GLES20.GL_RGBA, GLES20.GL_UNSIGNED_BYTE, pinbuffer);            
        for(i=0;i<y;i++)
        {   for(j=0;j<x;j++)
            {   z = pin[(y-1-i)*x+j];
                pout[i*x+j] = (z & 0xff000000) | ((z >> 16) & 0x000000ff) | ((z << 16) & 0x00ff0000) | (z  & 0x0000ff00); 
            }
        }
        Bitmap map = Bitmap.createBitmap(x, y, Bitmap.Config.ARGB_8888);
        map.setPixels(pout, 0, x, 0,0, x, y);
        OutputStream stream = new FileOutputStream("/sdcard/info/test.png");
        map.compress(CompressFormat.PNG, 100, stream);
        stream.close();
        return true;
    } catch (Exception e)
    {   e.printStackTrace();
        return false;
    }
}
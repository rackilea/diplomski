public void drawLine(Vector3 origin, Vector3 destination, int color)
{
    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    GL11.glLineWidth(3.0F);
    GL11.glDisable(GL11.GL_DEPTH_TEST);
    GL11.glDepthMask(false);
    GL11.glBegin(GL11.GL_LINES);

    float red = (float)((color & 0xFF0000) >> 16);
    float green = (float)((color & 0x00FF00) >> 8);
    float blue = (float)(color & 0x0000FF);
    GL11.glColor3f(red, green, blue);

    double diffX = destination.x() - origin.x() + 0.05D;
    double diffY = destination.y() - origin.y() - 1.35D;
    double diffZ = destination.z() - origin.z() - 0.05D;

    GL11.glVertex3d(0.0D, 0.0D, 0.0D);
    GL11.glVertex3d( -diffX, -diffY, -diffZ);

    GL11.glEnd();
    GL11.glDepthMask(true);
    GL11.glEnable(GL11.GL_DEPTH_TEST);
}
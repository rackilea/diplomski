import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

public class CameraControls {

CGSize winSize = CCDirector.sharedDirector().displaySize();
CGPoint CameraPos = CGPoint.ccp(winSize.width, winSize.height);
CGPoint previousLocation;
double minX;
double maxX;
double minY;
double maxY;

public CameraControls(World world)
{
    this.loadCamera(world);
}

public void setCameraLimit(float minX, float maxX, float minY, float maxY)
{
    this.minX = minX;
    this.maxX = maxX;
    this.minY = minY;
    this.maxY = maxY;
}

public void loadCamera(World world)
{
    float[] x = new float[1];
    float[] y = new float[1];
    float[] z = new float[1];
    world.getCamera().getCenter(x, y, z);
    CameraPos.x = x[0];
    CameraPos.y = y[0]; 
}

public void trackTouchMovement(CGPoint location, World world)
{
    if(previousLocation == null)
    {
        previousLocation = location;
    }
    CGPoint movement = CGPoint.ccpSub(previousLocation, location);
    previousLocation = location;
    float[] x1 = new float[1];
    float[] y1 = new float[1];
    float[] z1 = new float[1];
    world.getCamera().getEye(x1, y1, z1);
    CameraPos.x = CameraPos.x + movement.x;
    CameraPos.y = CameraPos.y + movement.y;

    try
    {
        if(CameraPos.x >= maxX || CameraPos.x <= minX || CameraPos.y >=  maxY || CameraPos.y <= minY)
        {
            CameraPos = CGPoint.ccpSub(CameraPos, movement);
        }
    }
    catch (NullPointerException e)
    {
        System.out.println("Invalid values for camera Limits. No Limits applied.");
    }

    world.getCamera().setCenter(CameraPos.x, CameraPos.y, 0);
    world.getCamera().setEye(CameraPos.x, CameraPos.y, z1[0]);
}

public void storePositionAsPrevious(CGPoint pos)
{
    previousLocation = pos;
}

public void resetPrevious()
{
    previousLocation = null;
}
}
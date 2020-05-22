@Override
public boolean ccTouchesMoved(MotionEvent event)
        {
            CGPoint location = CCDirector.sharedDirector().convertToGL(CGPoint.ccp(event.getX(), event.getY()));
            camera.trackTouchMovement(location, this);
            return true;
        }
@Override
public boolean ccTouchesEnded(MotionEvent event)
{
            camera.resetPrevious();
            return true;
}
@Override
public boolean ccTouchesBegan(MotionEvent event)
{
            CGPoint location = CCDirector.sharedDirector().convertToGL(CGPoint.ccp(event.getX(), event.getY()));
            camera.storePositionAsPrevious(location);
            return true;
}
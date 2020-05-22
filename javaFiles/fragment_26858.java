CGEventRef pointGetEvent = CGEventCreate(NULL);
CGPoint point = CGEventGetLocation(pointGetEvent);
CFRelease(pointGetEvent);

if(test(SNES_Y)){
    CGPoint oldPoint = point;
    if(test(SNES_LEFT)){
        point = CGPointMake(point.x - MOUSE_STEP, point.y);
    }
    if(test(SNES_RIGHT)){
        point = CGPointMake(point.x + MOUSE_STEP, point.y);
    }
    if(test(SNES_DOWN)){
        point = CGPointMake(point.x, point.y + MOUSE_STEP);
    }
    if(test(SNES_UP)){
        point = CGPointMake(point.x, point.y - MOUSE_STEP);
    }

    if(oldPoint.x != point.x || oldPoint.y != point.y){
        CGEventRef move1 = CGEventCreateMouseEvent(NULL, kCGEventMouseMoved, point, kCGMouseButtonLeft);
        CGEventSetDoubleValueField(move1, kCGMouseEventDeltaX, point.x - oldPoint.x);
        CGEventSetDoubleValueField(move1, kCGMouseEventDeltaY, point.y - oldPoint.y);
        CGEventPost(kCGSessionEventTap, move1);
        CFRelease(move1);
    }
}
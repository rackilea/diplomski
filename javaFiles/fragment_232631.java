Path Measure pm = new PathMeasure(myPath, false);
    pm.getPosTan(0, floatPoints, null);

    //This functions says whether the offset from path was too great to accept
    private boolean isMajorOffset(float point1, float point2, int tolerance){
                float difference = Math.abs(point1 - point2);
                return tolerance < Math.floor(difference) && tolerance < Math.ceil(difference);
            }

private void touch_start(float x, float y){
        //get point as float
        float floatPoints[] = {0f, 0f};
        //get current start point
        pm.getPosTan(0, floatPoints, null);

        Point startPoint = new Point((int)floatPoints[0], (int)floatPoints[1]);

        //if startPoint is selected then set path as started
        if((startPoint.x >= x - TOUCH_TOLERANCE && startPoint.x <= x + TOUCH_TOLERANCE)
                && (startPoint.y >= y - TOUCH_TOLERANCE && startPoint.y <= y + TOUCH_TOLERANCE))
        {
            PathStarted = true;
            Toast.makeText(this.getContext(), "Started", Toast.LENGTH_SHORT).show();

            //move trail path to this point
            trailPath.moveTo(startPoint.x, startPoint.y);
        }
    }

private void touch_move(float x, float y){
        if(PathStarted==false){
            return;
        }
        //get lenght of trail path
        PathMeasure tm = new PathMeasure(trailPath, false);

        //get point as float
        float floatPoints[] = {0f, 0f};
        //get current start point
        pm.getPosTan(tm.getLength() + 1, floatPoints, null);

        Point point = new Point((int)floatPoints[0], (int)floatPoints[1]);

        //if offset is ok continue with trail path
        if(!isMajorOffset(point.x, x, TOUCH_TOLERANCE) && !isMajorOffset(point.y, y, TOUCH_TOLERANCE))
        {
            //move current path to this point
            trailPath.lineTo(point.x, point.y);
        }
        else {
            PathStarted = false;
            Toast.makeText(this.getContext(), "Ended", Toast.LENGTH_SHORT).show();

        }
    }
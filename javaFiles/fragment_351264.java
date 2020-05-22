private void drawLinesRotate(Canvas canvas) {

    Paint paint = new Paint();
    paint.setStrokeWidth(10);

    //rotation angle
    SharedPreferences Angleprefs = this.getContext().getSharedPreferences("prefAngles", Context.MODE_PRIVATE);
    double angle = Angleprefs.getFloat("angle", 0);
    double rotateAngle = Math.toRadians(angle); //rotate angle has to be in radians
//rotation point on the left
        SharedPreferences prefs = this.getContext().getSharedPreferences("prefRotate", Context.MODE_PRIVATE);
        float cX_Left = prefs.getFloat("centerPointLeftX", 0);
        float cY_Left = prefs.getFloat("centerPointLeftY", 0);
        //*******left side********* 
        //RED line
        paint.setColor(Color.RED);
        int topPoint = dangerousLineY;
        int bottomPoint = gridBottomPoint;
        int leftPoint = gridLeftPoint;
    int newX1 = (int) (Math.cos(rotateAngle) * ((float) leftPoint) - Math.sin(rotateAngle) * (float) bottomPoint - cX_Left * Math.cos(rotateAngle) + cY_Left * Math.sin(rotateAngle) + cX_Left);
    int newY1 = (int) (Math.sin(rotateAngle) * leftPoint + bottomPoint * Math.cos(rotateAngle) - cX_Left * Math.sin(rotateAngle) - cY_Left * Math.cos(rotateAngle) + cY_Left);
    int newX2 = (int) (Math.cos(rotateAngle) * (leftPoint + (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE)))) - Math.sin(rotateAngle) * topPoint -
            cX_Left * Math.cos(rotateAngle) + cY_Left * Math.sin(rotateAngle) + cX_Left);
    int newY2 = (int) (Math.sin(rotateAngle) * (leftPoint + (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE)))) + Math.cos(rotateAngle) * topPoint -
            cX_Left * Math.sin(rotateAngle) - cY_Left * Math.cos(rotateAngle) + cY_Left);
    canvas.drawLine(newX1, newY1, newX2, newY2, paint);

    leftPoint = dangerousLineXLeft;
    bottomPoint = topPoint;
    //horizontal line
    canvas.drawLine(newX2, newY2, newX2 + 100, newY2, paint);
//        //YELLOW line
    bottomPoint -= 30;
    leftPoint = leftPoint + (int) (30 * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE)));
    topPoint = warningLineY;
    paint.setColor(Color.YELLOW);

    newX1 = (int) (Math.cos(rotateAngle) * ((float) leftPoint) - Math.sin(rotateAngle) * (float) bottomPoint - cX_Left * Math.cos(rotateAngle) + cY_Left * Math.sin(rotateAngle) + cX_Left);
    newY1 = (int) (Math.sin(rotateAngle) * leftPoint + bottomPoint * Math.cos(rotateAngle) - cX_Left * Math.sin(rotateAngle) - cY_Left * Math.cos(rotateAngle) + cY_Left);
    newX2 = (int) (Math.cos(rotateAngle) * (leftPoint + (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE + 5)))) - Math.sin(rotateAngle) * topPoint -
            cX_Left * Math.cos(rotateAngle) + cY_Left * Math.sin(rotateAngle) + cX_Left);
    newY2 = (int) (Math.sin(rotateAngle) * (leftPoint + (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE + 5)))) + Math.cos(rotateAngle) * topPoint -
            cX_Left * Math.sin(rotateAngle) - cY_Left * Math.cos(rotateAngle) + cY_Left);
    canvas.drawLine(newX1, newY1, newX2, newY2, paint);
    leftPoint = leftPoint + (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE + 5)));
    bottomPoint = topPoint;
    canvas.drawLine(newX2, newY2, newX2 + 100, newY2, paint);
//        //GREEN line
        bottomPoint -= 30;
        leftPoint = leftPoint + (int) (30 * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE + 5)));
        topPoint = safeLineY;
        paint.setColor(Color.GREEN);

    newX1 = (int) (Math.cos(rotateAngle) * ((float) leftPoint) - Math.sin(rotateAngle) * (float) bottomPoint - cX_Left * Math.cos(rotateAngle) + cY_Left * Math.sin(rotateAngle) + cX_Left);
    newY1 = (int) (Math.sin(rotateAngle) * leftPoint + bottomPoint * Math.cos(rotateAngle) - cX_Left * Math.sin(rotateAngle) - cY_Left * Math.cos(rotateAngle) + cY_Left);
    newX2 = (int) (Math.cos(rotateAngle) * (leftPoint + (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE + 10)))) - Math.sin(rotateAngle) * topPoint -
            cX_Left * Math.cos(rotateAngle) + cY_Left * Math.sin(rotateAngle) + cX_Left);
    newY2 = (int) (Math.sin(rotateAngle) * (leftPoint + (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE + 10)))) + Math.cos(rotateAngle) * topPoint -
            cX_Left * Math.sin(rotateAngle) - cY_Left * Math.cos(rotateAngle) + cY_Left);
    canvas.drawLine(newX1, newY1, newX2, newY2, paint);
    canvas.drawLine(newX2, newY2, newX2 + 100, newY2, paint);

    //*******right side*********
    //rotation point on the right
    float cX_Right = prefs.getFloat("centerPointRightX", 0);
    float cY_Right = prefs.getFloat("centerPointRightY", 0);
    angle *= -1; //right side angle should be (-)
    rotateAngle = Math.toRadians(angle);
    //RED line
    paint.setColor(Color.RED);
    topPoint = dangerousLineY;
    bottomPoint = gridBottomPoint;
    int rightPoint = gridRightPoint;


    newX1 = (int) (Math.cos(rotateAngle) * ((float) rightPoint) - Math.sin(rotateAngle) * (float) bottomPoint - cX_Right * Math.cos(rotateAngle) + cY_Right * Math.sin(rotateAngle) + cX_Right);
    newY1 = (int) (Math.sin(rotateAngle) * rightPoint + bottomPoint * Math.cos(rotateAngle) - cX_Right * Math.sin(rotateAngle) - cY_Right * Math.cos(rotateAngle) + cY_Right);
    newX2 = (int) (Math.cos(rotateAngle) * (rightPoint - (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE)))) - Math.sin(rotateAngle) * topPoint -
            cX_Right * Math.cos(rotateAngle) + cY_Right * Math.sin(rotateAngle) + cX_Right);
    newY2 = (int) (Math.sin(rotateAngle) * (rightPoint - (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE)))) + Math.cos(rotateAngle) * topPoint -
            cX_Right * Math.sin(rotateAngle) - cY_Right * Math.cos(rotateAngle) + cY_Right);
    canvas.drawLine(newX1, newY1, newX2, newY2, paint); //vertical line

    //horizontal line
    rightPoint = dangerousLineXRight;
    bottomPoint = topPoint;
    canvas.drawLine(newX2, newY2, newX2 - 100, newY2, paint);

    //YELLOW line
    bottomPoint -= 30;
    rightPoint = rightPoint - (int) (30 * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE)));
    topPoint = warningLineY;
    paint.setColor(Color.YELLOW);
    newX1 = (int) (Math.cos(rotateAngle) * ((float) rightPoint) - Math.sin(rotateAngle) * (float) bottomPoint - cX_Right * Math.cos(rotateAngle) + cY_Right * Math.sin(rotateAngle) + cX_Right);
    newY1 = (int) (Math.sin(rotateAngle) * rightPoint + bottomPoint * Math.cos(rotateAngle) - cX_Right * Math.sin(rotateAngle) - cY_Right * Math.cos(rotateAngle) + cY_Right);
    newX2 = (int) (Math.cos(rotateAngle) * (rightPoint - (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE + 5)))) - Math.sin(rotateAngle) * topPoint -
            cX_Right * Math.cos(rotateAngle) + cY_Right * Math.sin(rotateAngle) + cX_Right);
    newY2 = (int) (Math.sin(rotateAngle) * (rightPoint - (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE + 5)))) + Math.cos(rotateAngle) * topPoint -
            cX_Right * Math.sin(rotateAngle) - cY_Right * Math.cos(rotateAngle) + cY_Right);
    canvas.drawLine(newX1, newY1, newX2, newY2, paint); //vertical line
    //horizontal line
    rightPoint = rightPoint - (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE + 5)));
    bottomPoint = topPoint;
    canvas.drawLine(newX2, newY2, newX2 - 100, newY2, paint);

    //GREEN line
    bottomPoint -= 30;
    rightPoint = rightPoint - (int) (30 * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE + 5)));
    topPoint = safeLineY;
    paint.setColor(Color.GREEN);
    newX1 = (int) (Math.cos(rotateAngle) * ((float) rightPoint) - Math.sin(rotateAngle) * (float) bottomPoint - cX_Right * Math.cos(rotateAngle) + cY_Right * Math.sin(rotateAngle) + cX_Right);
    newY1 = (int) (Math.sin(rotateAngle) * rightPoint + bottomPoint * Math.cos(rotateAngle) - cX_Right * Math.sin(rotateAngle) - cY_Right * Math.cos(rotateAngle) + cY_Right);
    newX2 = (int) (Math.cos(rotateAngle) * (rightPoint - (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE + 10)))) - Math.sin(rotateAngle) * topPoint -
            cX_Right * Math.cos(rotateAngle) + cY_Right * Math.sin(rotateAngle) + cX_Right);
    newY2 = (int) (Math.sin(rotateAngle) * (rightPoint - (int) ((bottomPoint - topPoint) * Math.tan(Math.toRadians(DISTANCE_GRID_ANGLE + 10)))) + Math.cos(rotateAngle) * topPoint -
            cX_Right * Math.sin(rotateAngle) - cY_Right * Math.cos(rotateAngle) + cY_Right);
    canvas.drawLine(newX1, newY1, newX2, newY2, paint); //vertical line
    //horizontal line
    canvas.drawLine(newX2, newY2, newX2 - 100, newY2, paint);
}
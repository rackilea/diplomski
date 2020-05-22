// set the shape of our radar blips
    oBlipPath.moveTo(0, -5);
    oBlipPath.lineTo(6, 0);
    oBlipPath.lineTo(0, 5);


    oBlipMatrix.setRotate(45, 0, 0);
    oBlipPath.transform(oBlipMatrix);

    // Paint all the enemies and radar blips!
    for(int i=0; i<iNumEnemies; i++){
        oEnemies[i].draw(canvas, (int)worldX, (int)worldY);
        if (oEnemies[i].bActive){
            //calculate the degree the object is from the center of the screen. 
            //(user is the player. this could be done easier using iWidth and iHeight probably)
            //we use a world coordinate system. worldY and worldX are subtracted
            fDegrees = (float)Math.toDegrees(Math.atan2((oEnemies[i].getEnemyCenterY()-worldY)-(iHeight / 2), (oEnemies[i].getEnemyCenterX()-worldX)-(iWidth / 2)));

            canvas.save();

            //get to the center
            canvas.translate((iWidth / 2 + 50) , (iHeight / 2 + 50) );

            //move a little bit depending on direction (trying to make arrows appear around a circle)
            //canvas.translate((float)(20 * Math.cos(fDegrees)), (float)(20* Math.sin(fDegrees)));

            //rotate canvas so arrows will rotate and point in the right direction
            canvas.rotate(fDegrees-45, -50, -50);

            //draw arrows
            canvas.drawPath(oBlipPath, oBlipPaint);
            canvas.restore();
        }

    }
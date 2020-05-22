collisionSheet = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.collision16);
collisionPic = new Bitmap[width][height];
collisionPicDest = Bitmap.createBitmap(width*tileSize, height*tileSize, Bitmap.Config.RGB_565);
collisionCanvas = new Canvas(collisionPicDest());
// ===============
// collision layer
// ===============
for (int y = 0; y < height; y++) {
  for (int x = 0; x < width; x++) {

    tileNbr = MapLoader.block[x][y];


    switch(tileNbr){
    case 169:
      // ============
      // normal block
      // ============
      collisionPic[x][y]= Bitmap.createBitmap(collisionSheet, 0, 0, tileSize, tileSize);
      collisionCanvas.drawBitmap(collisionPic[x][y],x*tileSize,y*tileSize,bitmapPaint);
      break;

      // do other cases..
    }
  }
is = new FileInputStream(new File(imagePath));
bis = new BufferedInputStream(is);
Bitmap bitmap = BitmapFactory.decodeStream(bis);
Bitmap useThisBitmap = Bitmap.createScaledBitmap(
    bitmap, parent.getWidth(), parent.getHeight(), true);
bitmap.recycle();
if(imagePath!=null){
    System.out.println("Hi I am try to open Bit map");
    wallpaperManager = WallpaperManager.getInstance(this);
    wallpaperDrawable = wallpaperManager.getDrawable();
    wallpaperManager.setBitmap(useThisBitmap);
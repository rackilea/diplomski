public class ClassName {

public static int bitmapSizeWidth;
public static int bitmapSizeHeight;
public static final int bitmapPadding = 8;
public static final int howManyImagesColumn = 3;
public static final int howManyImagesRows = 2;

public static Bitmap folderBitmap(ArrayList<Bitmap> bitmapArray, int imageViewWidth, int imageViewHeight) {
    bitmapSizeWidth = imageViewWidth;
    bitmapSizeHeight = imageViewHeight;

    Bitmap b = Bitmap.createBitmap(bitmapSizeWidth, bitmapSizeHeight, Bitmap.Config.RGB_565);
    Canvas c = new Canvas(b);

    //Lets do it in a set coordinate system now
    if (bitmapArray.size() >= 1)
        c.drawBitmap(bitmapArray.get(0), bitmapPadding, bitmapPadding, paint);

    if (bitmapArray.size() >= 2)
        c.drawBitmap(bitmapArray.get(1), calculateSecondCoord().xPos, bitmapPadding, paint);

    if (bitmapArray.size() >= 3)
        c.drawBitmap(bitmapArray.get(2), calculateThirdCoord().xPos, bitmapPadding, paint);

    if (bitmapArray.size() >= 4)
        c.drawBitmap(bitmapArray.get(3), bitmapPadding, calculateSecondCoord().yPos, paint);

    if (bitmapArray.size() >= 5) {
        c.drawBitmap(bitmapArray.get(4), calculateSecondCoord().xPos, calculateSecondCoord().yPos, paint);
    }

    if (bitmapArray.size() >= 6) {
        c.drawBitmap(bitmapArray.get(5), calculateThirdCoord().xPos, calculateSecondCoord().yPos, paint);
    }

    return b;
}

public static BitmapSize calculateSingleBitmapSize(int imageViewWidth, int imageViewHeight) {
    bitmapSizeWidth = imageViewWidth;
    bitmapSizeHeight = imageViewHeight;
    BitmapSize bsize = new BitmapSize();
    bsize.widthSize = (int) (bitmapSizeWidth -
            (bitmapPadding * (howManyImagesColumn + 1))) / howManyImagesColumn;
    bsize.heightSize = (int) (imageViewHeight - (bitmapPadding * (howManyImagesRows + 1))) / howManyImagesRows;
    return bsize;
}

/*
 * First coord = padding
 * Second coord (bitmapPadding) + calculateSingleBitmapSize(bitmapSizeWidth);
 * Third coord (bitmapPadding * 3) + (calculateSingleBitmapSize(bitmapSizeWidth) * 2)
 * The math is supposed to be correct but can perhaps be done in a more efficient way
 */
private static BitmapCoord calculateSecondCoord() {
    BitmapCoord bCoord = new BitmapCoord();
    bCoord.xPos = (int) (bitmapPadding * (howManyImagesColumn - 1)) + calculateSingleBitmapSize(bitmapSizeWidth, bitmapSizeHeight).widthSize;
    bCoord.yPos = (int) (bitmapPadding * (howManyImagesRows)) + calculateSingleBitmapSize(bitmapSizeWidth, bitmapSizeHeight).heightSize;

    return bCoord;
}

private static BitmapCoord calculateThirdCoord() {
    BitmapCoord bCoord = new BitmapCoord();
    bCoord.xPos = (int) (bitmapPadding * howManyImagesColumn) + calculateSingleBitmapSize(bitmapSizeWidth, bitmapSizeHeight).widthSize * 2;
    bCoord.yPos = (int) (bitmapPadding * howManyImagesRows - 1) + calculateSingleBitmapSize(bitmapSizeWidth, bitmapSizeHeight).heightSize * 2;

    return bCoord;
}

public static class BitmapSize {
    public int widthSize;
    public int heightSize;
}

static class BitmapCoord {
    int xPos;
    int yPos;
}
}
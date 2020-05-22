public static Bitmap convertByteArrayToBitmap(
    byte[] byteArrayToBeCOnvertedIntoBitMap)
{
    bitMapImage = BitmapFactory.decodeByteArray(
        byteArrayToBeCOnvertedIntoBitMap, 0,
        byteArrayToBeCOnvertedIntoBitMap.length);
    return bitMapImage;
}
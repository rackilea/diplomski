/**
 * it return size of Bitmap in Bytes.
 */
fun Bitmap.size(): Int{
    val s = rowBytes * height
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
        return try {
            allocationByteCount
        } catch (npe: NullPointerException) {
            s
        }
    }
    return s
}
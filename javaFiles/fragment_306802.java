private fun getConvexHull(contours:ArrayList<MatOfPoint>):ArrayList<MatOfPoint>
{
    val hullInt:MatOfInt = MatOfInt()
    val hullPointList = mutableListOf<org.opencv.core.Point>() // changed
    val hullPointMat = MatOfPoint()  // changed
    val hullPoints = ArrayList<MatOfPoint>()
    var Image: Bitmap = textureView.getBitmap()
    var mROI = Mat()

    for(eachCont in contours){
        Imgproc.convexHull(eachCont, hullInt)
        for (eachHull in hullInt.toList())
            hullPointList.add(eachCont.toList().get(eachHull))
        hullPointMat.fromList(hullPointList)
        hullPoints.add(hullPointMat)
    }
    Utils.bitmapToMat(Image,mROI)
    Imgproc.drawContours(mROI,hullPoints,-1,Scalar(255.0,0.0,0.0,255.0),1)
}
static List<Rect> findTextBlocks(Mat dilated)
{
    Mat labels = new Mat();
    Mat stats = new Mat();
    Mat centroids = new Mat();
    // Find connected components
    int numberOfLabels = Imgproc.connectedComponentsWithStats(dilated,labels,stats,centroids,8, CvType.CV_16U);
    List<Rect> textBlocks = new ArrayList<>();
    // adjust this threshold as your desire
    double sizeThreshold = 0.01;
    // Label 0 is considered to be the background label, so we skip it
    for (int i = 1; i < numberOfLabels; i++)
    {
        // stats columns; [0-4] : [left top width height area}
        Rect textBlock = new Rect(new Point(stats.get(i,0)[0],stats.get(i,1)[0]),new Size(stats.get(i,2)[0],
                stats.get(i,3)[0]));
        // stats.get(i,4)[0] is the area of the connected component / Filtering out small areas
        if (Double.compare(stats.get(i,4)[0],dilated.height() * dilated.width() * sizeThreshold) > 0){
            textBlocks.add(textBlock);
        }
    }
    return textBlocks;
}

static void paintTextBlocks(List<Rect> textBlocks, Mat original)
{
    for (Rect r : textBlocks)
    {
        Imgproc.rectangle(original, new Point(r.x,r.y), new Point(r.x+r.width,r.y+r.height),
                new Scalar(100.0),2);
    }
}
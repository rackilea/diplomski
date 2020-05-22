int area,total=0;
List<Rect> contourRects = new ArrayList();

for(int i=0; i<contours.size(); i++)
{
    area = (int) Imgproc.contourArea(contours.get(i));

    if(area>4600 && area<5100)
    {
        contourRects.add(Imgproc.boundingRect(contours.get(i)));                          
    }
}
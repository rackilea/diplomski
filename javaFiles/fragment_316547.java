Mat src = imread("input.jpg"), tmp;

cvtColor(src, tmp, CV_BGR2GRAY);
threshold(tmp, tmp, 200, 255, THRESH_OTSU);

Mat element = getStructuringElement(MORPH_RECT, Size(3, 3), Point(1, 1));
dilate(tmp, tmp, element);
erode(tmp, tmp, element);
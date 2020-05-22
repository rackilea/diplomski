CvSeq lines = null;//Ref 9
lines = cvHoughLines2( Edges,
        storage,
        CV_HOUGH_PROBABILISTIC,
        1,
        Math.PI/180,           
        44,// threshold
        2,
        1 );
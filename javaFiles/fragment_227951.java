import java.io.*;
import java.util.*;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_calib3d.*;

/**
 *
 * @author rics
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
    List<CvPoint2D32f> points = new ArrayList<CvPoint2D32f>();
    List<CvPoint2D32f> known = new ArrayList<CvPoint2D32f>();
    // points and known should be filled with valid values
    // here are just some ad-hoc numbers that do not result a singular (unsolvable) configuration 
    for(int i=0; i < 2; i++){
        points.add(cvPoint2D32f((double)i,10 - 2* (double)i));
        known.add(cvPoint2D32f((double)i,10 - 2*(double)i));
    }
    for(int i=2; i < 5; i++){
        points.add(cvPoint2D32f((double)i,(double)i));
        known.add(cvPoint2D32f((double)i,(double)i));
    }
    CvMat matsrc = cvCreateMat(points.size(), 2, CV_32FC1);
    CvMat matdst = cvCreateMat(known.size(), 2, CV_32FC1);

    // filling the matrices with the point coordinates
    for(int s=0; s < points.size(); s++){
        CvPoint2D32f p = points.get(s);//.get("Point");
        //Add this point to matsrc                         
        matsrc.put(s,0,p.x());
        matsrc.put(s,1,p.y());
    }

    for(int s=0; s < known.size(); s++){
        CvPoint2D32f p = known.get(s);//.get("Point");
        //Add this point to matdst                         
        matdst.put(s,0,p.x());
        matdst.put(s,1,p.y());
    }

    CvMat mat = cvCreateMat(3, 3, CV_32FC1);
    cvFindHomography(matsrc, matdst, mat); //Here the matrices created are used to find the 3x3 Homography transform Matrix
    // displaying the resulting matrix
    for( int i = 0; i < 3; ++i) {
        for( int j = 0; j < 3; ++j) {
        System.out.print(mat.get(i,j) + ",");
        }
        System.out.println();
    }
    }
}
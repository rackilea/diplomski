import com.googlecode.javacv.*;
import com.googlecode.javacv.cpp.*;
import com.googlecode.javacpp.IntPointer;

final int numPoints = 10;
int pt2[] = new int[numPoints*2], x = 0, y = 1;
float testPar[] = new float[4];// to store the results

void setup() {
  for (int i = 0; i < numPoints; i++) {
    pt2[ i*2 ] = i * 5; pt2[ i*2 + 1 ] = i * 5;
  }

  opencv_core.CvMat point_mat = opencv_core.cvMat(1, numPoints, opencv_core.CV_32SC2, new IntPointer(pt2));
  opencv_imgproc.cvFitLine(point_mat, opencv_imgproc.CV_DIST_HUBER, 0, 0.01, 0.01,testPar);

  for (int i = 0; i < testPar.length; i++) 
    println("i: " + i + ", testPar: " + testPar[i]);
  exit(); 
}
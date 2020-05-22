package javaapplication2;


import java.util.ArrayList;
import java.util.List;
import org.bytedeco.javacpp.Pointer;
import static org.bytedeco.javacpp.opencv_calib3d.*;
import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_highgui.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;

public class JavaApplication2 {

    public static void main(String[] args) throws Exception  {
        System.loadLibrary("opencv_core249");//without these two lines, I get unsatisfied link exception on my pc. you should unzip the contents of opencv-windows-x86_64.jar etc to a folder and run with -Djava.library.path="C:\opencv\javacv-bin\bin"
        System.loadLibrary("jniopencv_core");
        Mat im =new Mat(480,640,CV_8UC3);//dummy
        Mat dst = null;//new Mat(480,640,CV_8UC1);//dummy

        final List<Point> pSrc=new ArrayList<Point>();
        final List<Point> pDst=new ArrayList<Point>();
        /*640x480 camera
        pDst.add(new Point(120,84)); //cam
        pDst.add(new Point(525,84));//cam
        pDst.add(new Point(525,427));//cam
        pDst.add(new Point(120,427));//cam
        */

        pDst.add(new Point(94,72));//notre
        pDst.add(new Point(343,72));//notre
        pDst.add(new Point(343,501));//notre
        pDst.add(new Point(94,501));//notre

        namedWindow("src",0);
        namedWindow("dst",0);

        MouseCallback mouseSrc= new MouseCallback() {
            @Override
            public void call(int event, int x, int y, int flags,Pointer param) {           
                if(event==CV_EVENT_LBUTTONDOWN)
                {
                    if(pSrc.size()>=4) pSrc.clear();
                    pSrc.add(new Point(x,y));         
                }
            }
        };

        setMouseCallback("src", mouseSrc, null);
        /* this should work but no..bug?
        MouseCallback moustDst= new MouseCallback() {
            @Override
            public void call(int event, int x, int y, int flags,Pointer param) {           
                if(event==CV_EVENT_LBUTTONDOWN)
                {
                    if(pDst.size()>=4) pDst.clear();
                    pDst.add(new Point(x,y));         
                }
            }
        };
        setMouseCallback("dst", moustDst, null);*/

        /* uncomment this one to read from webcam
        VideoCapture cap = new VideoCapture(1);
        while (cap.read(im)) {*/
        im = imread("c:/data/notre.jpg");
        while(true){
            if(dst==null)
            {
                dst=im.clone();
            }
            Mat imD = im.clone();
            Mat dstD = dst.clone();
            for(int i=0;i<pSrc.size();++i)
            {
                circle(imD,pSrc.get(i),4,new Scalar(255,0,0,255),-1,1,1);
            }

            if(pSrc.size()==4 && pDst.size()==4)
            {
                Mat msrc = new Mat(4,2,CV_64FC1);
                Mat mdst = new Mat(4,2,CV_64FC1);
                for(int i=0;i<pSrc.size();++i)
                {
                    //this is probably not the right way for element access, but I cant find a more straightforward way
                    msrc.asCvMat().put(i,0,(double)pSrc.get(i).x());
                    msrc.asCvMat().put(i,1,(double)pSrc.get(i).y());
                }

                for(int i=0;i<pDst.size();++i)
                {
                    mdst.asCvMat().put(i,0,(double)pDst.get(i).x());
                    mdst.asCvMat().put(i,1,(double)pDst.get(i).y());
                }
                Mat H =findHomography(msrc, mdst );
                warpPerspective(imD, dstD, H, new Size(dstD.cols(),dstD.rows()));
            }
            for(int i=0;i<pDst.size();++i)
            {
                circle(dstD,pDst.get(i),4,new Scalar(255,255,0,255),-1,1,1);
            }
            imshow("src",imD);
            imshow("dst",dstD);

            if(cvWaitKey(1)==27)
                break;
        }
        //cap.release();
    }    
}
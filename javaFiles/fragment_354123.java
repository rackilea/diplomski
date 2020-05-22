int kernelSize = 3; // 3x3 filter
int resultType = CvType.CV_32F; // CvType, not Imgproc !
double sigma = 1.2; // whatever you choose.

Mat kernel = Imgproc.getGaussianKernel(kernelSize, sigma, resultType);

// now apply the filter:
Mat filtered = new Mat();
Imgproc.filter2D(image, filtered, CvType.CV_32F, kernel);
public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
mImageRGBA = inputFrame.rgba();

img_object = Imgcodecs.imread("D:\\Project_Android\\Car_Tracking_1\\app\\src\\main\\res\\drawable\\rear_of_car.png");
Imgcodecs.imwrite("D:\\Project_Android\\Car_Tracking_1\\app\\src\\main\\res\\drawable\\test.png",img_object);
Log.i("aaa2", img_object.dump());

return mImageRGBA;
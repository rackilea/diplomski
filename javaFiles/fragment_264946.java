private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
    @Override
    public void onManagerConnected(int status) {
        if (status == LoaderCallbackInterface.SUCCESS ) {
            // now we can call opencv code !
        } else {
            super.onManagerConnected(status);
        }
    }
};

@Override
public void onResume() {;
    super.onResume();
    OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_5,this, mLoaderCallback);
    // you may be tempted, to do something here, but it's *async*, and may take some time,
    // so any opencv call here will lead to unresolved native errors.
}


@Override
public void onCameraViewStarted(int width, int height) {
     // probably the best place for your opencv code
}
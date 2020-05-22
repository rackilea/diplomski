private MyCameraView mOpenCvCameraView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        mOpenCvCameraView = (MyCameraView) view.findViewById(R.id.fd_activity_surface_view);
        mOpenCvCameraView.setCvCameraViewListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mOpenCvCameraView.enableView();

        String filename = "teste.jpg";
        mOpenCvCameraView.takePicture(filename);
        mOpenCvCameraView.disableView();
    }
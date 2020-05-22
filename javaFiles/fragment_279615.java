@Override
        public void onCheckedChanged(RadioGroup group,
                int checkedId) {
            if (checkedId == com.finarx.opencv.camera.R.id.lowest) {
                cameraView.setMaxFrameSize(320, 280);
                cameraView.disableView();
                cameraView.enableView();
                resolutionChange.dismiss();
            } else if (checkedId == com.finarx.opencv.camera.R.id.low) {
                cameraView.setMaxFrameSize(480, 320);
                cameraView.disableView();
                cameraView.enableView();
                resolutionChange.dismiss();
            } else if (checkedId == com.finarx.opencv.camera.R.id.vga) {
                cameraView.setMaxFrameSize(640, 480);
                cameraView.disableView();
                cameraView.enableView();
                resolutionChange.dismiss();
            } else if (checkedId == com.finarx.opencv.camera.R.id.higher) {
                cameraView.setMaxFrameSize(800, 600);
                cameraView.disableView();
                cameraView.enableView();
                resolutionChange.dismiss();
            } else if (checkedId == com.finarx.opencv.camera.R.id.highest) {
                cameraView.setMaxFrameSize(1280, 720);
                cameraView.disableView();
                cameraView.enableView();
                resolutionChange.dismiss();
            }
        }
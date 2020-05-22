protected boolean initializeCamera(int width, int height) {
        ...
                params.setPreviewFormat(ImageFormat.NV21);
                // "generic" = android emulator
                if (Build.BRAND.equalsIgnoreCase("generic")) {
                    params.setPreviewFormat(ImageFormat.YV12);
                }
                ...
                mCamera.setParameters(params);
                params = mCamera.getParameters();
                previewFormat = params.getPreviewFormat();
        ...
}
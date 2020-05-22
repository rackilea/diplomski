Surface imageSurface = imageReader.getSurface();
List<Surface> surfaceList = new ArrayList<>();
//...add other surfaces
previewRequestBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
previewRequestBuilder.addTarget(imageSurface);
            surfaceList.add(imageSurface);
cameraDevice.createCaptureSession(surfaceList,
                    new CameraCaptureSession.StateCallback() {
//...implement onConfigured, onConfigureFailed for StateCallback
}, null);
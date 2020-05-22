CaptureRequest.Builder captureRequestBuilder =
            cameraStore.state().cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_ZERO_SHUTTER_LAG);

         captureRequestBuilder.addTarget(previewStore.state().previewSurface);
         captureRequestBuilder.addTarget(photoStore.state().yuvImageReader.getSurface());
         state.session.setRepeatingRequest(captureRequestBuilder.build(), state.zslCaptureCallback, handlers.bg());
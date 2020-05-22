try {
        //Retrieve the last image stored by the zslImageReader
        Image image = zslImageReaderListener.getImage();
        //Retrieve the last totalCaptureResult from the zslCaptureCallback and create a reprocessableCaptureRequest with it
        TotalCaptureResult captureResult = sessionStore.state().zslCaptureCallback.getCaptureResult(image.getTimestamp());
        CaptureRequest.Builder captureRequest = cameraStore.state().cameraDevice.createReprocessCaptureRequest(captureResult);
        //Add the desired target and values to the captureRequest
        captureRequest.addTarget(state().jpegImageReader.getSurface());
        //Queued back to ImageWriter for future consumption.
        state.zslImageWriter.queueInputImage(image);
        //Drain all the unused and queued CapturedResult from the CaptureCallback
        sessionStore.state().zslCaptureCallback.drain();
        //Capture the desired frame
        CaptureRequest futureCaptureResult = captureRequest.build();
        sessionStore.state().session.capture(futureCaptureResult, new CameraCaptureSession.CaptureCallback() {
           @Override
           public void onCaptureCompleted(@NonNull CameraCaptureSession session,
                                          @NonNull CaptureRequest request,
                                          @NonNull TotalCaptureResult result) {
              Dispatcher.dispatchOnUi(new PhotoStatusChangedAction(PhotoState.Status.SUCCESS));
           }

           @Override
           public void onCaptureFailed(@NonNull CameraCaptureSession session,
                                       @NonNull CaptureRequest request,
                                       @NonNull CaptureFailure failure) {
              super.onCaptureFailed(session, request, failure);
              Exception captureFailedException = new RuntimeException(
                 String.format("Capture failed: Reason %s in frame %d, was image captured? -> %s",
                    failure.getReason(),
                    failure.getFrameNumber(),
                    failure.wasImageCaptured()));
              Timber.e(captureFailedException, "Cannot take mediaType, capture failed!");

              Dispatcher.dispatchOnUi(new PhotoStatusChangedAction(PhotoState.Status.ERROR, captureFailedException));
           }
        }, this.handlers.bg());

        //Capture did not blow up, we are taking the photo now.
        newState.status = PhotoState.Status.TAKING;

     } catch (CameraAccessException | InterruptedException| IllegalStateException | IllegalArgumentException | SecurityException e) {
        Timber.e(e, "Cannot take picture, capture error!");
        newState.status = PhotoState.Status.ERROR;
     }
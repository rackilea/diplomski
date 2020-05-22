//Configure preview surface
     Size previewSize = previewState.previewSize;
     previewState.previewTexture.setDefaultBufferSize(previewSize.getWidth(), previewSize.getHeight());

     ArrayList<Surface> targets = new ArrayList<>();
     for (SessionOutputTarget outputTarget : state.outputTargets) {
        Surface surface = outputTarget.getSurface();
        if (surface != null) targets.add(surface);
     }
     targets.add(previewState.previewSurface);
     CameraCharacteristics cameraCharacteristics = cameraStore.state().availableCameras.get(cameraStore.state().selectedCamera);
     Size size = CameraCharacteristicsUtil.getYuvOutputSizes(cameraCharacteristics).get(0);

     InputConfiguration inputConfiguration = new InputConfiguration(size.getWidth(),
        size.getHeight(), ImageFormat.YUV_420_888);

     CameraCaptureSession.StateCallback sessionStateCallback = new CameraCaptureSession.StateCallback() {
        @Override
        public void onConfigured(@NonNull CameraCaptureSession session) {
           if (sessionId != currentSessionId) {
              Timber.e("Session opened for an old open request, skipping. Current %d, Request %d", currentSessionId, sessionId);
              //performClose(session);
              return;
           }

           try {
              session.getInputSurface();
              //This call is irrelevant,
              //however session might have closed and this will throw an IllegalStateException.
              //This happens if another camera app (or this one in another PID) takes control
              //of the camera while its opening
           } catch (IllegalStateException e) {
              Timber.e("Another process took control of the camera while creating the session, aborting!");
           }

           Dispatcher.dispatchOnUi(new SessionOpenedAction(session));
        }

        @Override
        public void onConfigureFailed(@NonNull CameraCaptureSession session) {
           if (sessionId != currentSessionId) {
              Timber.e("Configure failed for an old open request, skipping. Current %d, request %d", currentSessionId, sessionId);
              return;
           }

           Timber.e("Failed to configure the session");
           Dispatcher.dispatchOnUi(new SessionFailedAction(session, new IllegalStateException("onConfigureFailed")));
        }
     };

     if (state.outputMode == OutputMode.PHOTO) {
        cameraState.cameraDevice.createReprocessableCaptureSession(inputConfiguration, targets, sessionStateCallback, handlers.bg());
     } else if (state.outputMode == OutputMode.VIDEO) {
        cameraState.cameraDevice.createCaptureSession(targets, sessionStateCallback, handlers.bg());
     }

  } catch (IllegalStateException | IllegalArgumentException e) {
     Timber.e(e, "Something went wrong trying to start the session");
  } catch (CameraAccessException e) {
     //Camera will throw CameraAccessException if another we try to open / close the
     //session very fast.
     Timber.e("Failed to access camera, it was closed");
  }
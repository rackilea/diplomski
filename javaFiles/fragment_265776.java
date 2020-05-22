public void FlashOn(Camera mCamera) throws RemoteException
    {   
        // Get Camera Params for customisation
        Camera.Parameters parameters = mCamera.getParameters();

        // Check Whether device supports AutoFlash, If you YES then set
        // AutoFlash
        List<String> flashModes = parameters.getSupportedFlashModes();

        if (flashModes.contains(android.hardware.Camera.Parameters.FLASH_MODE_TORCH))
        {
            parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);

            isFlashOn = true;
        }
        else if (flashModes.contains(Parameters.FLASH_MODE_ON))
        {
            parameters.setFlashMode(Parameters.FLASH_MODE_ON);

            isFlashOn = true;
        }

        mCamera.setParameters(parameters);

        mCamera.startPreview();

        //mCamera.autoFocus(null);  // may be this is problem
    }



    public void FlashOff(Camera mCamera) throws RemoteException
    {
        // Get Camera Params for customisation
        Camera.Parameters parameters = mCamera.getParameters();

        // Check Whether device supports AutoFlash, If you YES then set
        // AutoFlash
        List<String> flashModes = parameters.getSupportedFlashModes();

        if (flashModes.contains(android.hardware.Camera.Parameters.FLASH_MODE_OFF))
        {
            parameters.setFlashMode(Parameters.FLASH_MODE_OFF);

            isFlashOn = false;
        }

        mCamera.setParameters(parameters);

        mCamera.startPreview();
    }
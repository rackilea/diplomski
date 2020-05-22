flashBtn.setOnClickListener(new OnClickListener()
{
    @Override
    public onClick(View view)
    {
        if(cameraView!=null)//cameraView is the CameraPreview.class
        {
            if(cameraView.isFlashOn() && isFlashRunning)
            {       
                cameraView.FlashOff(camera);

                isFlashRunning = false;                             
            }
            else
            {
                cameraView.FlashOn(camera); 

                isFlashRunning = true;  
            }
    }
});
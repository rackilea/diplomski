for (int x = 0; x < myString.length(); x++) {
    if (myString.charAt(x) == '1') {                
          params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
          camera.setParameters(params);
          camera.startPreview();
    }     
    Thread.sleep(300);      


    params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
    camera.setParameters(params);


}
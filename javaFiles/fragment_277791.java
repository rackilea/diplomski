public String getCHINdex(String tsDataJSON){
          MWCharArray number1 = null;
          Object[] result = null;
          Calibration calibration = null;

          try
          {
             number1 = new MWCharArray(tsDataJSON)   ; // Array of Input to be sent to MATLAB Runtime
             calibration = new Calibration();
             result = calibration.calibrationAPI(1, number1);

             if(result.length >= 1){
                  return result[0].toString();
             }
          }
          catch (Exception e)
          {
             e.printStackTrace();
          }
          finally
          {
             MWArray.disposeArray(number1);
             MWArray.disposeArray(result);
             calibration.dispose();
          }

          return null;

    }
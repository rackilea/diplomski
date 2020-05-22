SoapObject resultString = (SoapObject) soapEnvelope.getResponse();           

            String addon = "";
            for(int i =0;i<resultString.getPropertyCount();i++)
            {                            
                SoapObject array2 = (SoapObject) resultString .getProperty(i);              
                addon = (addon + "ID = " + array2.getProperty(0).toString() + array2.getProperty(1).toString() + array2.getProperty(2).toString() + "\n");  
            }
            tv.setText(addon.toString());
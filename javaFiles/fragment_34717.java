SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
            SoapSerializationEnvelope soapEnvelop;
            soapEnvelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelop.dotNet = true;
            soapEnvelop.setOutputSoapObject(Request);
            HttpTransportSE htps = new HttpTransportSE(URL);

            htps.call(SOAP_ACTION, soapEnvelop);
            response = (SoapObject) soapEnvelop.getResponse();    
            ar = new String[response.getPropertyCount()];

            arrays = new ArrayList<Byte>();

            if (response != null) {

                if (response.getPropertyCount() > 0) {                  

                    for (int i = 0; i < response.getPropertyCount(); i++) {

                        arrays.add( (Byte) response.getProperty(i)); 
                    }
                }
            }
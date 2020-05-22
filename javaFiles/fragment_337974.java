public  String sendSoapRequest(String serverAdress, String message , String SOAPAction)
        {
            OutputStream httpOutputStream = null;
            byte[] byteArrayStream = message .getBytes();

            URL url = null;
            try {
                url = new URL("http://"+serverAdress);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = (HttpURLConnection)url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Set the appropriate HTTP parameters.
            httpURLConnection.setRequestProperty("Content-Length",
                    String.valueOf(byteArrayStream.length));
            httpURLConnection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            httpURLConnection.setRequestProperty("SOAPAction", SOAPAction);
            try {
                httpURLConnection.setRequestMethod("POST");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            try {
                httpOutputStream = httpURLConnection.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Write the content of the request to the outputstream of the HTTP Connection.
            try {
                httpOutputStream.write(byteArrayStream);
                httpOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            BufferedReader httpInputBuufferedReader = null;
            try {
                httpInputBuufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(LOG_TAG,"IOException reading HTTP Input message ");
                return null;
            }

            //Write the SOAP message response to a String.
            StringBuilder returnOutputString = new StringBuilder();
            try {
                String line = "";
                while ((line = httpInputBuufferedReader.readLine()) != null) {
                    returnOutputString.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(LOG_TAG, "IOEception while reading HTTP input buffered reading");
            }
            return returnOutputString.toString();
        }
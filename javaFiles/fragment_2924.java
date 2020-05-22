public int uploadFile(String sourceFileUri) {

    String fileName = sourceFileUri; // the path to my .db file

    HttpURLConnection connection = null;
    DataOutputStream dataOutputStream = null;
    String lineEnd = "\r\n";
    String twoHyphens = "--";
    String boundary = "*****";
    int bytesRead, bytesAvailable, bufferSize;
    byte[] buffer;
    int maxBufferSize = 1 * 1024 * 1024;
    File sourceFile = new File(sourceFileUri);

    if (!sourceFile.isFile()) {

        Log.e("uploadFile", "Source File not exist ");
        return 0;
    } else {
        try {

            // open a URL connection to the Servlet
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            URL url = new URL(upLoadServerUri);

            // Open a HTTP  connection to  the URL
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true); // Allow Inputs
            connection.setDoOutput(true); //Triggers  http POST method.

            connection.setUseCaches(false); // Don't use a Cached Copy
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("ENCTYPE", "multipart/form-data");
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            //conn.setRequestProperty("Content-Type", "application/x-sqlite3; boundary=" + boundary);// when I tried this it didn't work, so you can delete this line
            connection.setRequestProperty("uploadedfile", fileName);

            dataOutputStream = new DataOutputStream(connection.getOutputStream());

            dataOutputStream.writeBytes(twoHyphens + boundary + lineEnd);
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=" + fileName + "" + lineEnd);
            dataOutputStream.writeBytes(lineEnd);

            // create a buffer of  maximum size
            bytesAvailable = fileInputStream.available();

            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = new byte[bufferSize];

            // read file and write it into form...
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);

            while (bytesRead > 0) {

                dataOutputStream.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);

            }

            // send multipart form data necesssary after file data...
            dataOutputStream.writeBytes(lineEnd);
            dataOutputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

            // Responses from the server (code and message)
            serverResponseCode = connection.getResponseCode();
            String serverResponseMessage = connection.getResponseMessage();

            Log.i("uploadFile", "HTTP Response is : " + serverResponseMessage + ": " + serverResponseCode);

            if (serverResponseCode == 200) {

                String msg = "server respose code ";
                Log.i(TAG, msg + serverResponseCode);
                StringBuilder result = new StringBuilder();

                InputStream in = new BufferedInputStream(connection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                //JSONObject mResponseJSONObject = new JSONObject(String.valueOf(result)); //convert the respons in json
                Log.i(TAG, msg + result);
            }

            //close the streams //
            fileInputStream.close();
            dataOutputStream.flush();
            dataOutputStream.close();

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            Log.e(TAG, "MalformedURLException Exception : check script url.");
            Log.e("Upload file to server", "error: " + ex.getMessage(), ex);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Upload file to server Exception : " + e.getMessage(), e);
        }

        return serverResponseCode;

    } // End else block
} //[End uploadFileToServer method]
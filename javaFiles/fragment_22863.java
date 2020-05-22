protected String doInBackground(String... args) {
            String end = "\r\n";
            String twoHyphens = "--";
            String boundary = "******";
            String result = "Ein Fehler ist aufgetreten";

            String charset = "UTF-8";
            String insertedReportID;

            try
            {
                insertedReportID = args[0];

                    /* BEGIN - ADD LOGIN CREDENTIALS TO THE QUERY */
                final String authKeyMail = "authMail";
                final String authKeyPW = "authPW";
                Context mContext = getContext();
                SharedPreferences mPrefs = mContext.getSharedPreferences("privPrefs", Context.MODE_PRIVATE);

                String email = mPrefs.getString(authKeyMail, "default");
                String pw = mPrefs.getString(authKeyPW,"default");

                HashMap<String, String> params = new HashMap<>();
                params.put("emailadr", email);
                params.put("passwrt", pw);

                StringBuilder sbParams = new StringBuilder();
                int i = 0;
                for (String key : params.keySet()) {
                    try {
                        if (i != 0){
                            sbParams.append("&");
                        }
                        sbParams.append(key).append("=")
                                .append(URLEncoder.encode(params.get(key), charset));

                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
                    /* END - ADD LOGIN CREDENTIALS TO THE QUERY */


                URL url = new URL(UPLOAD_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url
                        .openConnection();
                // allow  input and output
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                // use POST way

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type",
                        "multipart/form-data;boundary=" + boundary);

                DataOutputStream dos = new DataOutputStream(
                        httpURLConnection.getOutputStream());


                //BEGIN - ADD LOGIN CREDENTIALS TO THE UPLOADER
                dos.writeBytes(twoHyphens + boundary + end);
                //"emailadr" MUST BE THE EXACT SAME NAME AS IN PHP $_POST['emailadr']
                dos.writeBytes("Content-Disposition: form-data; name=\"emailadr\""+ end);
                dos.writeBytes(end);

                dos.writeBytes(email);
                dos.writeBytes(end);
                dos.writeBytes(twoHyphens + boundary + end);

                //"passwrt" MUST BE THE EXACT SAME NAME AS IN PHP $_POST['passwrt']
                dos.writeBytes("Content-Disposition: form-data; name=\"passwrt\""+ end);
                dos.writeBytes(end);
                dos.writeBytes(pw);
                dos.writeBytes(end);
                dos.writeBytes(twoHyphens + boundary + end);
                //END - ADD LOGIN CREDENTIALS TO THE UPLOADER

                //"playgroundID" MUST BE THE EXACT SAME NAME AS IN PHP $_POST['equipmentID']
                dos.writeBytes("Content-Disposition: form-data; name=\"reportID\""+ end);
                dos.writeBytes(end);
                dos.writeBytes(insertedReportID);
                dos.writeBytes(end);
                dos.writeBytes(twoHyphens + boundary + end);
                //END - ADD LOGIN CREDENTIALS TO THE UPLOADER

                for(int j=0;j<uploadImages.size();j++){
                    //"image_file" MUST BE THE EXACT SAME NAME AS IN PHP $_FILES['image_file']
                    dos.writeBytes("Content-Disposition: form-data; name=\"image_file[]\"; filename=\""
                            + uploadImages.get(j).substring(uploadImages.get(j).lastIndexOf("/") + 1)
                            + "\""
                            + end);
                    dos.writeBytes(end);

                    FileInputStream fis = new FileInputStream(uploadImages.get(j));
                    byte[] buffer = new byte[8192]; // 8k
                    int count = 0;

                    while ((count = fis.read(buffer)) != -1)
                    {
                        dos.write(buffer, 0, count);
                    }
                    fis.close();
                    dos.writeBytes(end);
                    dos.writeBytes(twoHyphens + boundary + end);
                }

                dos.close();

                InputStream is = httpURLConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "utf-8");
                BufferedReader br = new BufferedReader(isr);
                result = br.readLine();

                is.close();
                httpURLConnection.disconnect();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            return result;
        }
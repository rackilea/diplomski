//Imports
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.james.mime4j.stream.NameValuePair;

//Adding data
    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    nameValuePairs.add(new NameValuePair("caption", sCaption));// String
    nameValuePairs.add(new NameValuePair("email", device_id));// String
    nameValuePairs.add(new NameValuePair("uploadedfile", path));//File path
    post(URLs.photoUpload, nameValuePairs);// Calling post function

//post function
    public void post(final String url, final List<NameValuePair> nameValuePairs) {
        // Setting progressDialog properties
        final ProgressDialog progressDialog = ProgressDialog.show(
                PhotoActivity.this, "", "Posting To Server...");

        final Handler mHandler = new Handler();
        // Function to run after thread
        final Runnable mUpdateResults = new Runnable() {
            public void run() {

                if (server) {
                    server = false;
                    Toast.makeText(getBaseContext(), "Posted To Server!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "Error!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        };
        new Thread() {
            @Override
            public void run() {

                System.out.println("URL:::" + url);
                System.out.println("SIZE:::" + nameValuePairs.size());
                // ///////////////
                HttpClient httpClient = new DefaultHttpClient();
                HttpContext localContext = new BasicHttpContext();
                HttpPost httpPost = new HttpPost(url);

                try {
                    MultipartEntity entity = new MultipartEntity(
                            HttpMultipartMode.BROWSER_COMPATIBLE);

                    for (int index = 0; index < nameValuePairs.size(); index++) {
                        if (nameValuePairs.get(index).getName()
                                .equalsIgnoreCase("uploadedfile")) {
                            // If the key equals to "image", we use FileBody
                            // to transfer the data
                            entity.addPart(
                                    nameValuePairs.get(index).getName(),
                                    new FileBody(new File(nameValuePairs.get(
                                            index).getValue())));
                        } else {
                            // Normal string data
                            entity.addPart(nameValuePairs.get(index).getName(),
                                    new StringBody(nameValuePairs.get(index)
                                            .getValue()));
                        }
                    }

                    httpPost.setEntity(entity);

                    HttpResponse response = httpClient.execute(httpPost,
                            localContext);
                    System.out.println(response.toString());
                    server = true;
                } catch (IOException e) {
                    e.printStackTrace();
                    server = false;
                }

                // dismiss the progress dialog
                progressDialog.dismiss();
                // Calling handler's post function
                mHandler.post(mUpdateResults);

            }
        }.start();

    }
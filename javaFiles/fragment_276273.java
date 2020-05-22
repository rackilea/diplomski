I have solved the problem

Spring Controller Code:

   @RequestMapping(method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) {       
        String username = request.getParameter("username");
        String password = request.getParameter("password");     
        response.addHeader("IS_VALID", "yes"); 
    }

**In android Activity class:**

public void login(View view) {
            Log.d("","This is login method......");         
            new ReqService().postData("username", "password");
        }


**ReqService Class:**

public class ReqService {

    public void postData(String username, String password) {
        new RmsLogin().execute("http://10.0.1.112:8080/myapp/idm/android-login", username, password);    // url of post method in spring controller
    } 

    private class RmsLogin extends AsyncTask<String, Object, Object> {

        private Exception exception;

        protected String doInBackground(String... params) {
            HttpClient httpclient = new DefaultHttpClient();
            String url = params[0];
            String username = params[1];
            String password = params[2];
            HttpPost httppost = new HttpPost(url);

            Log.d("httppost =",httppost.getURI().toString());
            try {
                // Add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("username", username));
                nameValuePairs.add(new BasicNameValuePair("password", password));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                // Execute HTTP Post Request
                HttpResponse response = httpclient.execute(httppost);
                String valid = response.getFirstHeader("IS_VALID").getValue();
                Log.d("response :", valid);             

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Object restult) {
            //Log.d("response :", String.valueOf(restult));
        }

    }

}
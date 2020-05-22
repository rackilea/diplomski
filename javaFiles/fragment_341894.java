protected Integer doInBackground(String... arg0) {
       /** According with the new StrictGuard policy,  running long tasks on the Main UI thread is not possible
       So creating new thread to create and execute http operations */
       new Thread(new Runnable() {

        @Override 
        public void run() {
         ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
         postParameters.add(new BasicNameValuePair("username",un.getText().toString()));
         postParameters.add(new BasicNameValuePair("password",pw.getText().toString()));

         String response = null;
         try {
          response = SimpleHttpClient.executeHttpPost("http://XXX.168.1.X:5555/LoginServlet/loginservlet.do", postParameters);
           res = response.toString();
           System.out.println("response :"+res);


         } catch (Exception e) {        
         // e.printStackTrace();
          errorMsg = e.getMessage();  
         }  
        }

       }).start();  

       /** Inside the new thread we cannot update the main thread
       So updating the main thread outside the new thread */
       try {

       }catch (Exception e) {  
    error.setText(e.getMessage());    
          // e.printStackTrace();
       }
    return null;
      }
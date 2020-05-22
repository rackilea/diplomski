private static RequestQueue myRequestQueue = null;

public String pare(final String url) throws Exception {   
   final String[] doc = new String[1];
   final CountDownLatch cdl = new CountDownLatch(1);

   StringRequest documentRequest = new StringRequest( //
        Request.Method.GET, //
        url, //
        new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
               doc[0] = Jsoup.parse(response).html();
               cdl.coutDown();
           }
        }, //
        new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               Log.e("MyActivity", "Error while fetching " + url, error);
           }
        } //
   );

   if (myRequestQueue == null) {
       myRequestQueue = Volley.newRequestQueue(this);
   }

   // Add the request to the queue...
   myRequestQueue.add(documentRequest);

   // ... and wait for the document.
   // NOTA: User experience can be a concern here. We shouldn't freeze the app...
   cdl.await();

   return doc[0];
}
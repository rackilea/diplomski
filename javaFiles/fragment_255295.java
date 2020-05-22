volleyWebService.getResponse("your url", context, new VolleyResponseListener() {
   @Override
   void onSuccess(JSONObject response) {
      //do what you want on success
   }

   @Override
   void onError(VolleyError error) {
      //do what you want on error
   }
});
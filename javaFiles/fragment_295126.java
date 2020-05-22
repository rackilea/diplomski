void onSuccess(String response){
// do what you want to do
}
void onError(VolleyError error){
// do what you want to do 
}   
 private void SaveInformationToServer(Information information)
        {

    RequestQueue queue = Volley.newRequestQueue(this);

    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {                           
                        onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                 onError(error);
            }
        });

        queue.add(stringRequest);
    }
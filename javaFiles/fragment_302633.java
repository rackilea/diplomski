private void getCustomerList() {


    AlertDialog.Builder statusDialog = new AlertDialog.Builder(SyncActivity.this);
    statusDialog.setPositiveButton("OK", null);
    statusDialog.setTitle("Status");

    urlRef = myRef.child("...");
    urlRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            ...

            StringRequest stringRequest = new StringRequest(Request.Method.GET, customerURL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    msg = msg + "Get customer success \n";

                     statusDialog.setMessage(msg);
                     statusDialog.show();
                     msg = "";


                    try {
                        ...
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    ...
                    msg = msg + "Get customer unsuccessful \n";
                    statusDialog.setMessage(msg);
                    statusDialog.show();
                    msg = "";

                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(SyncActivity.this);
            requestQueue.add(stringRequest);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            ...
        }
    });


}
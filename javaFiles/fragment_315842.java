public void query(String url,Consumer<JSONObject> cons) {
    Req = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            Retour = response;
            callb.accept(Retour);
        }
    },
    new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Retour = null;
            callb.accept(null);
        }
    });
    Queue.add(Req);
}
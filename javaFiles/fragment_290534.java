// Instantiate the RequestQueue.
RequestQueue queue = Volley.newRequestQueue(this);
String url ="http://test123.com/games/whichcity/app/check-form.php?gender=" + gender + "&anger=" + anger + "&food=" + food + "&gettowork=" + gettowork + "&settlement=" + settelment + "&actor=" + actor + "&weather=" + weather + "&weekend=" + weekend + "&color=" + color + "&age=" + age;

// Request a string response from the provided URL.
StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
    @Override
    public void onResponse(String response) {
        //handle response from server
        result.setText(response);
    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        //handle error
        result.setText("That didn't work!");
    }
});
// Add the request to the RequestQueue.
queue.add(stringRequest);
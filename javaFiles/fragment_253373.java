RequestHandlerInterface rh = this;  //Your main class should implement this method
    RequestQueue rq = Volley.newRequestQueue(getActivity().getApplicationContext());
    String url= "http://grwn.ddns.net:1337/results";
    final String body = "{\"id\":1}";
    VolleyStringRequest volleyStringRequest = new VolleyStringRequest(url, body, rh);
    rq.add(volleyStringRequest.createStringRequest());
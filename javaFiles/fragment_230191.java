public interface JsonParser_<T> {
        public T parseResponse_(JSONObject json);

        public T parseResponse_(JSONArray json);
    }



/**
     * 
     * @param tag
     *            : to tag your request with some string, so that you can cancel
     *            them any time
     * @param method
     *            <pre>
     * int DEPRECATED_GET_OR_POST = -1;
     * int GET = 0;
     * int POST = 1;
     * int PUT = 2;
     * int DELETE = 3;
     * int HEAD = 4;
     * int OPTIONS = 5;
     * int TRACE = 6;
     * int PATCH = 7;
     * </pre>
     * @param url
     *            URL to hit
     * @param postParams
     *            Parameters that embeds with the URL itself
     * @param headerParams
     *            Parameters that goes inside header
     * @param jsonDelivery
     *            Listener will be called with JSON so that you can parse your
     *            JSON off the UI thread
     * @param resultDelivery
     *            It will return the resulf of delivery, very important to
     *            return the result in the first listener in parsing JSON
     * @param errorListener
     *            It anything goes wrong
     */
    @SuppressWarnings("hiding")
    protected final <T> void fetchAndParseResponse(final String tag,
            final int method, final String url,
            final Map<String, String> postParams,
            final Map<String, String> headerParams,
            final JsonParser_<T> jsonDelivery,
            final Response.Listener<T> resultDelivery,
            final Response.ErrorListener errorListener) {

        AppContext.requestQueue.start();

        AppContext.requestQueue.add(new Request<T>(method, url,
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        setException(error);
                        if (errorListener != null)
                            // errorListener.onErrorResponse(wrapError(error));
                            errorListener.onErrorResponse(error);
                    }
                }) {

            @Override
            protected Response<T> parseNetworkResponse(NetworkResponse response) {

                T pojo = null;

                statusCode = response.statusCode;

                try {

                    String jsonString = new String(response.data, "UTF-8");
                    char char_ = new JSONTokener(jsonString).next();

                    if (char_ == '{') {

                        JSONObject json = new JSONObject(jsonString);

                        // isResponseOk(json);

                        pojo = jsonDelivery.parseResponse_(json);

                    } else {

                        JSONArray json = new JSONArray(jsonString);
                        pojo = jsonDelivery.parseResponse_(json);

                    }

                } catch (UnsupportedEncodingException e) {

                    setException(e);
                    // return Response.error(wrapError(new VolleyError(e)));
                    return Response.error((new VolleyError(e)));

                } catch (JSONException e) {

                    setException(e);
                    // return Response.error(wrapError(new VolleyError(e)));
                    return Response.error((new VolleyError(e)));
                }

                return Response.success(pojo,
                        HttpHeaderParser.parseCacheHeaders(response, true));

            }

            @Override
            protected VolleyError parseNetworkError(VolleyError volleyError) {
                if (volleyError.networkResponse != null
                        && volleyError.networkResponse.data != null) {
                    VolleyError error = new VolleyError(new String(
                            volleyError.networkResponse.data));
                    volleyError = error;
                }

                return volleyError;
            }

            @Override
            protected void deliverResponse(T response) {
                if (resultDelivery != null)
                    resultDelivery.onResponse(response);
                else
                    VolleyLog.wtf("No listener attached with %s class", this
                            .getClass().getName());
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headerParams == null) {
                    Map<String, String> map = new HashMap<String, String>(1);
                    if (AppContext.userPojo != null) {
                        map.put("sid", AppContext.userPojo.SID);
                    }
                    return map;
                } else {
                    if (AppContext.userPojo != null) {
                        headerParams.put("sid", AppContext.userPojo.SID);
                    }
                }

                return headerParams;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (postParams == null)
                    return super.getParams();
                else
                    return postParams;
            }
        }.setRetryPolicy(new DefaultRetryPolicy()).setTag(tag));

    }
fetchAndParseResponse(tag, Method.POST, AZ_API.SOME_URL, null, null, new JsonParser_<StatusMessage>() {

            @Override
            public StatusMessage parseResponse_(JSONObject json) {

                requestStatus = parseStatus(json);
                message = parseMessage(json);

                StatusMessage msg = new StatusMessage();
                msg.setMessage(message);
                msg.setStatus(requestStatus);

                return msg;

            }

            @Override
            public StatusMessage parseResponse_(JSONArray json) {

                return null;
            }

        }, listener, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {                
                errorListener.onErrorResponse(error);
            }
        });
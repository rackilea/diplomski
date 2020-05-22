getApi().getMessage(messageNumber, true,
                    new Response.Listener<MessageData>() {
                        @Override
                        public void onResponse(MessageData data) {

                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            resolveResponseStatus(error);
                        }

                    }
            );
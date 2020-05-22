@Override
            public Map<String, String> getHeaders() {
                HashMap<String, String> headers = new HashMap<String, String>();

                headers.put("Accept", "application/json");
                return headers;
            }

@Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded";
            }
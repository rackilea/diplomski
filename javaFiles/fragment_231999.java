//make needful changes for this method if any parameter has multiple values, eg: usernames = "Visruth", usernames = "visruth CV" and etc..
private static String getQuery(Map<String, Object> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Entry<String, Object> pair : params.entrySet() ) {


            if (first) {
                first = false;
            } else {
                result.append("&");
            }


            result.append(URLEncoder.encode(pair.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue().toString(), "UTF-8"));
        }

        return result.toString();
    }
public static void main(String[] args) throws JSONException {
        String domainRequest = "{\"companyName\":{\"Company Name:\":\"kjh\",\"Address 1:\":\"kjhhkh\",\"Address 2:\":\"hkjhkj\",\"Address 3:\":\"hkjhhkj\",\"Address 4:\":\"kjhj\",\"Postcode:\":898,\"Default Email Address:\":\"kkjkh@y\",\"Company Registration No:\":98,\"VAT No:\":89098,\"Website\":\"http://localhost:9000/#/support/domain/request?formLinkUuid=7f000101-4fdf-160d-814f-dfa60dc80000\"}}";
        JSONObject jsonObject = new JSONObject(domainRequest);
        JSONObject jsonMap = (JSONObject) jsonObject.get("companyName"); // Generates HashMap, key-value pair
        String companyName = (String) jsonMap.get("Company Name:"); // from map prepared above get key value
        System.out.println(companyName);
    }
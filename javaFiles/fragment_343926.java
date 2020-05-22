try {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8181/xyz/updateAdmin";
        JSONArray json = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("a_username", "testabcd");
        obj.put("a_id", 1);
        //obj.put("a_password", "N/A");
        json.put(obj);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("Content-Type", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> entity = new HttpEntity<String>(obj.toString(), headers);
        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);


    } catch(Exception ex) {
        ex.printStackTrace();
    }
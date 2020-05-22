RestTemplate restTemplate = new RestTemplate();
    response = (ResponseEntity<String>) restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

    JSONObject jsonObj = new JSONObject(response.getBody().toString());

    JSONArray c = jsonObj.getJSONArray("value");

    for (int i = 0; i < c.length(); i++) {
        JSONObject obj = c.getJSONObject(i);
        String VMName = obj.getString("name");
        VMNames vmnames = new VMNames();
        vmnames.setName(VMName);
        vmNames.add(vmnames);
    }

    return vmNames;
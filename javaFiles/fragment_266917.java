JSONArray headers = new JSONObject();
headers.add("ID");
headers.add("Organization Name");
headers.add("Submission Date");
headers.add("Status");

JSONObject organizationsHJ = new JSONObject();
organizationsHJ.put("headers", headers);

array.add(organizationsHJ );
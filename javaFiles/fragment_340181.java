try {
        String data = "[{\"clientNumber\":\"33\"},{\"clientName\":\"34\"},{\"clientEik\":\"35\"}]";

        JSONArray jsonArr = new JSONArray(URLDecoder.decode(data, "UTF-8"));
        JSONObject dataObj = new JSONObject();
        dataObj.put("data", jsonArr);

        JSONArray jsonarr = dataObj.getJSONArray("data");

        String clientNumber = jsonarr.getJSONObject(0).getString(
                "clientNumber");
        System.out.println(clientNumber);
        String clientName = jsonarr.getJSONObject(1)
                .getString("clientName");
        System.out.println(clientName);
        String clientEik = jsonarr.getJSONObject(2).getString("clientEik");
        System.out.println(clientEik);

    } catch (Exception e) {
        e.printStackTrace();
    }
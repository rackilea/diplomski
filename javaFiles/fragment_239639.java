String str = "{" + 
            "    \"gb\": [" + 
            "        {" + 
            "            \"omrid\": \"gis-n\"," + 
            "            \"status\": 0," + 
            "            \"grupp\": 1" + 
            "        }," + 
            "        {" + 
            "            \"omrid\": \"gis-s\"," + 
            "            \"status\": 0," + 
            "            \"grupp\": 1" + 
            "        }," + 
            "        {" + 
            "            \"omrid\": \"gis-c\"," + 
            "            \"status\": 0," + 
            "            \"grupp\": 1" + 
            "        }," + 
            "        {" + 
            "            \"omrid\": \"gis-h\"," + 
            "            \"status\": 0," + 
            "            \"grupp\": 1" + 
            "        }," + 
            "        {" + 
            "            \"omrid\": \"gis-g\"," + 
            "            \"status\": 0," + 
            "            \"grupp\": 1" + 
            "        }," + 
            "        {" + 
            "            \"omrid\": \"hes\"," + 
            "            \"status\": 0," + 
            "            \"grupp\": 2" + 
            "        }" + 
            "    ]" + 
            "}";

    JSONObject jsonObject = new JSONObject(str);

    JSONArray gb = jsonObject.getJSONArray("gb");

    for (int j = 0; j < gb.length(); j++) {
        JSONObject element = gb.getJSONObject(j);

        int status = element.getInt("status");
        int grupp = element.getInt("grupp");
        String omrid = element.getString("omrid");

        System.out.println("status=" + status + "; grupp=" + grupp + "; omrid=" + omrid);

//create togglebutton here
    }
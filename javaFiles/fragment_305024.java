private void CheckifUserisContact() {
    StringRequest stringRequest = new StringRequest(Request.Method.POST, CHECKPHONENUMBER_URL,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String response) {
            //We have a response so clear the list
            MatchingContactsAsArrayList.clear();

            String MatchingContactsAsString = response.toString();

            try {
              JSONArray Object = new JSONArray(MatchingContactsAsString);
              //for every object in the Array
              for (int x = 0; x < Object.length(); x++) {
                final JSONObject obj = Object.getJSONObject(x);
                final String userMatch = obj.getString("usernameMatch");
                if (!MatchingContactsAsArrayList.contains(userMatch) {
                    MatchingContactsAsArrayList.add(userMatch);
                }
              }

      System.out.println("The contacts are :" + MatchingContactsAsArrayList);
...........
        ...................

        if (success == 1) {
            // resorts found
            // Getting Array of resorts
            resorts = json.getJSONArray("resorts");
            rates = json.getJSONArray("room_prices");

            int i;

            // looping through All resorts
            for (i = 0; i < resorts.length() & i < rates.length(); i++) {
                // Storing each json item in variable
                String name = resorts.getString(i);
                String price = rates.getString(i);

                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();

                // adding each child node to HashMap key => value
                map.put(TAG_NAME, name);
                map.put(TAG_ROOM_PRICE, price);

                // adding HashList to ArrayList
                resortsList.add(map);
            }

        }
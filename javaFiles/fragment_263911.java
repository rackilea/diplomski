final String json = "[{\"ParkingSpaces;;;;\":\"Name;CarPlate;Description;ExpirationDate;Owner\","
{\"ParkingSpaces;;;;\":\"A5;T555;Parkingspace A5;;\"},{\"ParkingSpaces;;;;\":\"A6;T666;Parkingspace A6;;\"},{\"ParkingSpaces;;;;\":\"A7;T777;Parkingspace A7;;\"},{\"ParkingSpaces;;;;\":\"\"}]";
        final org.json.JSONArray jSONArray = new JSONArray(json);
        for (int i = 0; i < jSONArray.length(); i++) {
            final org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
            final String parkingSpaces = jSONObject.getString("ParkingSpaces;;;;");
            final String spaces[] = parkingSpaces.split(";");
            System.out.println(Arrays.toString(spaces));
        }
    }
JSONParser jsonParser2 = new JSONParser();
        try (FileReader reader = new FileReader("Locations.json")) {
            Object obj = jsonParser2.parse(reader);

            JSONArray locationsList = (JSONArray) obj;

            //Iterate over locations array
            locationsList.forEach(emp -> parseJSONLocations((JSONObject) emp, locations, objects));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException | ParseException e) {
            System.out.println(e);
        }
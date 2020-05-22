public void printJson(String fileName) {

    String filePath = getCacheDir() + "/" + fileName + ".json";
    Gson gson = new Gson();
    MyAirports airports = null;

    try {
        //airport = gson.fromJson(new FileReader(filePath), Airport.class);
        airports = gson.fromJson(new FileReader(filePath), MyAirports.class);
    } catch (FileNotFoundException e) {
    }
    Log.i("MSG", airports.getAirportList().get(0).toString());
}
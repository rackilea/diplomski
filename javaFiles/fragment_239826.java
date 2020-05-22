Log.d("Length Array 0", String.valueOf(airports.length()));
Log.d("Length Array 1", String.valueOf(arrayAirports.size()));
for (Iterator<String> nameIter = airports.keys(); nameIter.hasNext(); ){
    String name = nameIter.next();
    JSONObject jsonAirport = airports.getJSONObject(name);
    // code
}
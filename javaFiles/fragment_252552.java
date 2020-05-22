class Time {
    @SerializedName(value="start_time")
    private String startTime;
    @SerializedName(value="end_time")
    private String endTime;

    // Getters Setters
}

Gson gson = new Gson();
Map<String, Map<String, Time>> data = gson.fromJson(json, new TypeToken<Map<String, Map<String, Time>>>() {}.getType());
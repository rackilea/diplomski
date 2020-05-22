public static void main(String[] args) {
    // This will built our list of missions
    List<Mission> missionsList = Arrays.asList(
            new Mission("name1", "102101"),
            new Mission("name2", "102801"),
            new Mission("name3", "104801"),
            new Mission("name4", "110501"),
            new Mission("name5", "120301")
    );

    // This map will keep the count of missions (value) per hour (key)
    Map<String, Integer> missionsPerHour = new HashMap<>();

    for (Mission mission : missionsList) {
        // Let's start by getting the hour,
        // this will act as the key of our map entry
        String hour = mission.getHour();

        // Here we get the count of the current hour (so far).
        // This is the "value" of our map entry
        int count = missionsPerHour.getOrDefault(mission.getHour(), 0);

        // Here we increment it (by adding/replacing the entry in the map)
        missionsPerHour.put(hour, count + 1);
    }

    // Once we have the count per hour,
    // we iterate over all the keys in the map (which are the hours).
    // Then we simply print the count per hour
    for (String hour : missionsPerHour.keySet()) {
        System.out.println(String.format(
            "%s\t=>\t%d", hour, missionsPerHour.get(hour)
        ));
    }
}
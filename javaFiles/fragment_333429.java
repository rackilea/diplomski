String[] quarterHours = {"00","15","30","45"};
List<String> times = new ArrayList<String>; // <-- List instead of array

for(int i = 0; i < 24; i++) {
    for(int j = 0; j < 4; j++) {
        String time = i + ":" + quarterHours[j];
        if(i < 10) {
            time = "0" + time;
        }
        times.add("Today " + time); // <-- no need to care about indexes
    }
}
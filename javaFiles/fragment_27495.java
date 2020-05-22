LocalTime time = LocalTime.MIDNIGHT;
int minutesToAdd = 30;
Map<Integer, String> times = new TreeMap<>();

for(int i = 1; i < 48; i++){
    times.put(i - 1,time.plusMinutes(minutesToAdd * i).toString());
}

times.put(47, "24:00");
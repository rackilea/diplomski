Map<Long, Flight> map = new HashMap<>();
for(Flight f : flights) {
    if(map.containsKey(f.id)) {
        if(map.get(f.id).destination.length() < f.destination.length()) {
            map.put(f.id, f);
        }
    } else {
        map.put(f.id, f);
    }
}

//you can even store them in a set
List<Flight> longestDestinationFlights = new ArrayList<>(map.values());
private Map<Integer, Track> tracks;
private PriorityQueue<Integer> deletedKeys;
private int nextKey;

public Register() {
    this.trains = new HashMap<>();
    this.deletedKeys = new PriorityQueue<>();
    this.nextKey = 0;
}

public void addTrack(Track track) {
    int id = nextKey;
    if (!deletedKeys.isEmpty()) id = deletedKeys.poll();
    this.tracks.put(id, track);
}

public void removeTrack(int id) {
    if (tracks.containsKey(id)) {
        this.tracks.remove(id);
        this.deletedKeys.add(id);
    } else {
        Terminal.printError("track with ID " + track.getId() + " doesn't exist.");
    }
}
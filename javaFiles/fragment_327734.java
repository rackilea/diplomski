private TreeMap<Integer, Track> tracks;

public Register() {
    this.trains = new TreeMap<>();
}

public void addTrack(Track track) {
    int id = 1;
    for (int key : this.trains.keySet) {
        if (key > id) break;
        id = key + 1;
    }
    this.tracks.put(id, track);
}

public void removeTrack(int id) {
    if (tracks.containsKey(id)) {
        this.tracks.remove(id);
    } else {
        Terminal.printError("track with ID " + track.getId() + " doesn't exist.");
    }
}
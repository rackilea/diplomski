public class MIDIFile {
    enum FileFormat {
        single_track,
        syncronous_multiple_tracks,
        assyncronous_multiple_tracks;
    }

    FileFormat file_format;
    short numberOfTracks;
    short deltaTimeTicks;

    //Create Class for tracks, events, put some collection for storing the tracks, 
    //some collection for storing the events inside the tracks, etc

    //Collection<Integer, MIDITrack> the type of Collection depends on application

}

public class MIDITrack {
    int length;
    //Collection<MIDIEvent> the type of Collection depends on application
}

public class MIDIEvent {
    int delta_time;
    int event_type;    //Use of enum or final variables is interesting
    int key;
    int velocity;
}
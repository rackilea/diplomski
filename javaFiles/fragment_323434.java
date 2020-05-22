import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Track {
    String track;

    public Track(String track) {
        this.track = track;
    }

    //overriding toString() method for Track class
    public String toString() {
        return track;
    }
}

class Album {
    String artistName;
    String albumTitle;
    List < Track > tracks = new ArrayList < Track > ();

    //Album Constructor
    public Album(String artistName, String albumTitle) {
        this.artistName = artistName;
        this.albumTitle = albumTitle;
    }

    public List < Track > getTracks() {
        return tracks;
    }

    public void setTracks(List < Track > tracks) {
        this.tracks = tracks;
    }

    //overriding the toString method for Album
    public String toString() {
        StringBuilder album = new StringBuilder();
        album.append("Artist name: " + artistName + "\n");
        album.append("\n Album title : " + albumTitle + "\n\n");

        for (int i = 0; i < tracks.size(); i++) {
            album.append("\n Track " + (i + 1) + ":" + tracks.get(i).toString());
        }

        return album.toString();
    }
}

public class ReadAlbums {
    public static void main(String[] args) {
        List < Album > albumsCollection = new ArrayList < Album > ();
        BufferedReader in = null;

        try { in = new BufferedReader(new FileReader("albums.txt"));
            String line;

            List < Track > currentTracks = new ArrayList < Track > ();
            Album album = null;

            while ((line = in .readLine()) != null) {
                //no need to put == true in the if condition 
                if (Character.isUpperCase(line.charAt(0))) {
                    //Album found 

                    String[] token = line.split(":");

                    //If the not the first ever album then add the previous album to the collection 
                    if (album != null) {
                        albumsCollection.add(album);
                    }

                    //new album object is created with artist name and album title 
                    album = new Album(token[0], token[1]);

                    //new empty track list is added to the album object
                    album.setTracks(new ArrayList < Track > ());
                } else {
                    //Track found

                    //retrieve the track from Album album
                    currentTracks = album.getTracks();

                    //Add the track to the list of tracks obtained from album
                    currentTracks.add(new Track(line));

                    //add the updated track list back to the album object
                    album.setTracks(currentTracks);
                }
            }

            //add the last album in the album collections
            if(album != null) {
                albumsCollection.add(album); 
            }

        //close the input stream
        in.close();
    } catch (IOException e) {}


    System.out.println("albums : " + albums.toString());
}
}
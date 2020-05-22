package snakeyaml;

import java.util.ArrayList;

public class Radios {

    ArrayList<RadioStation> stations = new ArrayList<RadioStation>();

    public ArrayList<RadioStation> getStations() {
        return stations;
    }

    public void setStations(ArrayList<RadioStation> stations) {
        this.stations = stations;
    }
}
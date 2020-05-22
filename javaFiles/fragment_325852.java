package com.example.athletics;

import java.util.ArrayList;
import java.util.Date;

public class Game {
    // Object fields
    int code;
    String name;
    Date gameDate; // perhaps an interval would be better here

    ArrayList<Athlete> players;


    public Game() {
        players = new ArrayList<Athlete>();
    };

    public void addPlayer(Athlete athlete) {
        players.add(athlete);
    }

    public boolean isParticipant(Athlete athlete) {
        // TODO improve performance by creating a HashMap perhaps?

        boolean result = false;
        for (int i=0; i < players.size(); i++) {
            if (athlete.equals(players.get(i))) {
                result = true;
                break;
            }
        }
        return result;
    }
}
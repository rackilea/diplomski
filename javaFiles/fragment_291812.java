package design.pattern;

import java.util.ArrayList;

public class GlobalAccessVariables {
      public ArrayList<Trip> trips;

      private GlobalAccessVariables() {
        trips = new ArrayList<Trip>();
      }

      private static GlobalAccessVariables instance;

      public static GlobalAccessVariables getInstance() {
        if (instance == null) 
            instance = new GlobalAccessVariables();
        return instance;
      }

}
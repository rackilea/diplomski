package com.google.transit.realtime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Date;

import com.google.transit.realtime.GtfsRealtime.FeedEntity;
import com.google.transit.realtime.GtfsRealtime.FeedHeader;
import com.google.transit.realtime.GtfsRealtime.FeedMessage;
import com.google.transit.realtime.GtfsRealtime.TripDescriptor;
import com.google.transit.realtime.GtfsRealtime.TripUpdate;
import com.google.transit.realtime.GtfsRealtime.TripUpdate.StopTimeUpdate;

public class GtfsRealtimeExample {
  public static void main(String[] args) throws Exception {

    URL url;
    String outputFile;
    if (args[0].startsWith("http")) {
      url = new URL(args[0]);
      outputFile = args[0].substring(args[0].lastIndexOf('/')+1).replaceFirst(".pb", ".txt");      
    }
    else {
      url = new File(args[0]).toURI().toURL();
      outputFile = args[0].replaceFirst(".pb", ".txt");
    }

    FeedMessage feed = FeedMessage.parseFrom(url.openStream());
    FeedHeader header = feed.getHeader();

    OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(outputFile));
    os.write(String.format("GTFS Realtime Version %s feed produced on %s with %d entities\n", 
        header.getGtfsRealtimeVersion(), new Date(header.getTimestamp()*1000).toString(), feed.getEntityCount()));

    for (FeedEntity entity : feed.getEntityList()) {

      if (entity.hasTripUpdate()) {
        TripUpdate tripUpdate = entity.getTripUpdate();

        int noStopTimeUpdates = tripUpdate.getStopTimeUpdateCount();
        int tripDelay = tripUpdate.getDelay();
        long tripTimestamp = tripUpdate.getTimestamp();

        TripDescriptor tripDescriptor = tripUpdate.getTrip();
        os.write(String.format("\nTRIP id=%s route=%s direction=%d, sch=%s, date=%s, time=%s, noStopUpdates=%d tripDelay=%d timestamp=%d\n", 
            tripDescriptor.getTripId(), tripDescriptor.getRouteId(), tripDescriptor.getDirectionId(), 
            tripDescriptor.getScheduleRelationship().getValueDescriptor().toString(), tripDescriptor.getStartDate(),
            tripDescriptor.getStartTime(), noStopTimeUpdates, tripDelay, tripTimestamp));

        for (StopTimeUpdate stoptimeUpdate : tripUpdate.getStopTimeUpdateList()) {
          os.write(String.format("  STOP id=%s seq=%d sch=%s arrTime=%s arrDelay=%d depTime=%s depDelay=%d\n", 
              stoptimeUpdate.getStopId(), stoptimeUpdate.getStopSequence(), 
              stoptimeUpdate.getScheduleRelationship().getValueDescriptor().toString(),
              new Date(stoptimeUpdate.getArrival().getTime()*1000).toString(), stoptimeUpdate.getArrival().getDelay(),
              new Date(stoptimeUpdate.getDeparture().getTime()*1000).toString(), stoptimeUpdate.getDeparture().getDelay()));
        }
      }
    }

    os.close();
  }
}
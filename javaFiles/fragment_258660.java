package demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;

public class SampleFilter extends TurboFilter {

    String marker;
    Marker markerToAccept;

    List<String> traceExp = new ArrayList<String>();
    List<String> debugExp = new ArrayList<String>();
    List<String> infoExp = new ArrayList<String>();
    List<String> warnExp = new ArrayList<String>();
    List<String> errorExp = new ArrayList<String>();

    @Override
    public FilterReply decide(Marker marker, Logger logger, Level level,
            String format, Object[] params, Throwable t) {
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }
        if(level.equals(Level.TRACE)){
            traceExp.add(format.substring(0, 10));
        }
        if(level.equals(Level.DEBUG)){
            debugExp.add(format.substring(0, 10));
        }
        if(level.equals(Level.INFO)){
            infoExp.add(format.substring(0, 10));
        }
        if(level.equals(Level.WARN)){
            warnExp.add(format.substring(0, 10));
        }
        if(level.equals(Level.ERROR)){
            errorExp.add(format.substring(0, 10));
        }
        if ((markerToAccept.toString().equals(format))) {
            System.out.println("TRACE Exp cnt : "+traceExp.size());
            System.out.println("DEBUG Exp cnt : "+debugExp.size());
            System.out.println("INFO Exp cnt : "+infoExp.size());
            System.out.println("WARN Exp cnt : "+warnExp.size());
            System.out.println("ERROR Exp cnt : "+errorExp.size());
        }
        return FilterReply.NEUTRAL;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String markerStr) {
        this.marker = markerStr;
    }

    @Override
    public void start() {
        if (marker != null && marker.trim().length() > 0) {
            markerToAccept = MarkerFactory.getMarker(marker);
            super.start();
        }
    }

}
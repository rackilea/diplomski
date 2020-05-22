public class MyConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        Marker marker = event.getMarker();
        if (marker == null || !(marker instanceof MyMarker)) {
            return null;
        }
        return ((MyMarker) marker).getSmtpTo();
    }
}
public String getDiscriminatingValue(ILoggingEvent e) {
    Marker marker = e.getMarker();
    if (marker == null || !(marker instanceof MyMarker)) {
        return null;
    }
    return ((MyMarker) marker).getDiscriminatingValue();
}
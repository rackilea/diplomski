private String getTimeString(long millis) {
    StringBuffer buf = new StringBuffer();

    int hours = millis / (1000*60*60);
    int minutes = ( millis % (1000*60*60) ) / (1000*60);
    int seconds = ( ( millis % (1000*60*60) ) % (1000*60) ) / 1000;

    buf
        .append(String.format("%02d", hours))
        .append(":")
        .append(String.format("%02d", minutes))
        .append(":")
        .append(tring.format("%02d", seconds));

    return buf.toString();
}
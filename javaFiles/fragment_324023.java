StringBuilder stringBuilder = new StringBuilder(gpxString);
        for (CCTrackLocation location: trackLocations) {
            if (isCancelled())
                return null;
            //Log.e("CCGPXUtils", "Time wasting");
            stringBuilder.append("<trkpt lat=\""+location.getLatitude()+"\" lon=\""+location.getLongitude()+"\">\n" +
                                                "<ele>"+location.getAltitude()+"</ele>\n" +
                                                "<time>"+CCDateUtility.convertTimestampIntoGPXFormat(location.getTimestamp())+"</time></trkpt>\n");
}
return stringBuilder.toString();
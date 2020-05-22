GpsDirectory gpsDir = (GpsDirectory) metadata.getFirstDirectoryOfType(GpsDirectory.class);

if (gpsDir != null) {
    GpsDescriptor gpsDesc = new GpsDescriptor(gpsDir);
    System.out.println("Latitude: " + gpsDesc.getGpsLatitudeDescription());
}
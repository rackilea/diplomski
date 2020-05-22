DefaultDateTypeAdapter(DateFormat enUsFormat, DateFormat localFormat) {
   this.enUsFormat = enUsFormat;
   this.localFormat = localFormat;
   this.iso8601Format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
   this.iso8601Format.setTimeZone(TimeZone.getTimeZone("UTC"));
}
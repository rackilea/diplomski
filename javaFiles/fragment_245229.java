private Date deserializeToDate(JsonElement json) {
    synchronized (localFormat) {
      try {
        return localFormat.parse(json.getAsString());
      } catch (ParseException ignored) {
      }
      try {
        return enUsFormat.parse(json.getAsString());
      } catch (ParseException ignored) {
      }
      try {
        return iso8601Format.parse(json.getAsString());
      } catch (ParseException e) {
        throw new JsonSyntaxException(json.getAsString(), e);
      }
    }
  }
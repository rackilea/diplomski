samples.update(
  query,
  new BasicDBObject(
    "$set",
    new BasicDBObject("foo.bar.time", new Date())
));
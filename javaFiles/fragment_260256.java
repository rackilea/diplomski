XContentBuilder object = XContentFactory.jsonBuilder()
 .startArray("amazingArray")
  .startObject()
   .field("uId","123")
   .startArray("cars")
    .value("fastCar")
    .value("slowCar")
   .endArray()
  .endObject()

  .startObject()
   ...
  .endObject()
 .endArray();
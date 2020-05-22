ObjectNode place = (ObjectNode)(root.findPath("transaction")
    .findPath("createdBy")
    .findPath("address")
    .findPath("place")
);
place.remove("number");
Iterator<JsonValue.ValueType> iter = list.iterator();
while (iter.hasNext()) {
    JsonValue.ValueType value = iter.next();
    println("removed: " + value);
    iter.remove();
}
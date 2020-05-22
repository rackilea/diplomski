final Iterator<String> iterator = uuids.iterator();
String uuid;
while (iterator.hasNext()) {
    uuid = iterator.next();
    if (!checkIfValidUUID(uuid))
        iterator.remove();
}
return uuids;
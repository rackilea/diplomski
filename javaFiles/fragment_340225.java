Number timeoutNum = (Number) paramJson.get("valInMs");
Long timeoutLong = null;
Double timeoutDouble = null;
if (timeoutNum instanceof Long) {
    timeoutLong = (Long) timeoutNum;
}
else if (timeoutNum instanceof Double) {
    timeoutDouble = (Double) timeoutNum;
}
else { ... punt ... }
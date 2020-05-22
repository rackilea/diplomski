for (String orderKey: insertMap.keySet()) {
    if (orderKey.contains("#New")) {
        doBigStuff(orderKey);
    }
}

for (String orderKey: updateMap.keySet()) {
    if (orderKey.contains("#New")) {
        doBigStuff(orderKey);
    }
}
Map<String, List<MeterBlink>> idToMetersMap = new HashMap<>();
for (MeterBlink meterBlink : createData()) {
    String meterId = meterBlink.getMeterId();
    List<MeterBlink> meterBlinkList = idToMetersMap.get(meterId);
    //if List doesn't exist create it and put in Map
    if (meterBlinkList == null) {
        meterBlinkList = new ArrayList<>();
        idToMetersMap.put(meterId, meterBlinksList)
    }
    meterBlinkList.add(meterBlink);       
}
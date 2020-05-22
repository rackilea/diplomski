MutableValue value = sourceNameMap.get(ticketId);
if (oldValue == null) {
    sourceNameMap.put(new MutableValue(entryValue));
} else {
    value.add(entryValue);
}
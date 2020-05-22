/** This method is entirely garbage-free, deserialization-free, and thread-safe. */
void putOneValue(ChronicleMap<ShortValue, LongList> map, ShortValue key, int index,
        long element) {
    if (index < 0) throw throw new IndexOutOfBoundsException(...);
    try (ExternalMapQueryContext<ShortValue, LongList, ?> c = map.getContext(key)) {
        c.writeLock().lock(); // (1)
        MapEntry<ShortValue, LongList> entry = c.entry();
        if (entry != null) {
            Data<LongList> value = entry.value();
            BytesStore valueBytes = (BytesStore) value.bytes(); // (2)
            long valueBytesOffset = value.offset();
            long valueBytesSize = value.size();
            int valueListSize = (int) (valueBytesSize / Long.BYTES); // (3)
            if (index >= valueListSize) throw new IndexOutOfBoundsException(...);
            valueBytes.writeLong(valueBytesOffset + ((long) index) * Long.BYTES,
                element);
            ((ChecksumEntry) entry).updateChecksum(); // (4)
        } else {
            // there is no entry for the given key
            throw ...
        }
    }
}
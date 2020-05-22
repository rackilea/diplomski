int prefixLen = keyPrefix.getLength();

try (Cursor cursor = store.openCursor(txn)) {
    if (cursor.getSearchKeyRange(keyPrefix) != null) {
        do {
            ByteIterable key = cursor.getKey();
            // check if the key starts with keyPrefix
            int keyLen = key.getLength();
            if (keyLen < prefixLen ||
                ByteIterableUtil.compare(keyPrefix, key.subIterable(0, prefixLen)) != 0) {
                break;
            }
            // wanted key/value pair is here
            ByteIterable value = cursor.getValue();
            ...

        } while(cursor.getNext());
    }
}
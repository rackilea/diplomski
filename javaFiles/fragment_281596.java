HashTableLinked entry = table[hashValue];
        boolean found = false;
        HashTableLinked priorEntry = null;
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                entry.setValue(entry.getValue() + 1);  //trying to add +1 for existing key 
                found = true;
                break;
            }
            priorEntry = entry;
            entry = entry.next;
        }
        if (!found) {
            if (priorEntry == null) {
                table[hashValue] = new HashTableLinked(key, value);
            } else {
                priorEntry.next = new HashTableLinked(key, value);
            }
        }
boolean found = false;
        for (HashTableLinked entry = table[hashValue]; entry != null; entry = entry.next) {
            if (entry.getKey().equals(key)) {
                entry.setValue(entry.getValue() + 1);  // trying to add 1 for existing key 
                found = true;
                break;
            }
        }
        if (!found) {
            HashTableLinked added = new HashTableLinked(key, value);
            added.next = table[hashValue];
            table[hashValue] = added;
        }
if (dups.containsKey(name)) {
               dups.put(name, dups.get(name) + 1);
            }
            else {
               dups.put(name, 1);
            }
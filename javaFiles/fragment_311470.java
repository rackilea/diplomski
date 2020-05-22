public void put(K key, V value){
      int hash= key.hashCode() % ROW_SIZE;
      int seenIt = hash;
      int j;
      for(j=0;j<COLUMN_SIZE;j++){
        while(table[hash][j] != null){
          if (table[hash][j].getKey().equals(key)) // overwrite the value
            hash=(hash+1)%ROW_SIZE;
        }
      }
      table[hash][j] = new HashEntry(key,value);
      numItems++;
    }
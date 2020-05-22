public void insert(int key, int value) {
    int hash_code = hash_code(key);
    if (hash_code < 0) {
        System.out.println("The hash table is full!!!");
        return;
    }
    hash_table[hash_code] = new HashTableNode(key, value);
    return;
}

public int linear_probing(int key) {

    for (int i = 0; i < table_size; i++) {
        // if we get next empty slot to insert new node then return the new hash code
        if (hash_table[((key + i) % table_size)] == null) {
            return ((key + i) % table_size);
        }
    }
    return -1;
}
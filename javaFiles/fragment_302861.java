public static void main(String[] args) {
    HashTableOpenAddressing ht = new HashTableOpenAddressing();
    ht.insert(10, 100);
    ht.insert(10, 1000);
    ht.insert(11, 101);
    ht.insert(11, 1001);
    ht.print_hash_table();
}
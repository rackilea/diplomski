Map<Character,Integer> indices = new HashMap<>();
for(int i = 0; i < column; i++) {
    // get the previous position of sorted_key[i] (or -1 is there is no previous position)
    int last = indices.computeIfAbsent(sorted_key[i],c->-1);
    // search for the next position of sorted_key[i]
    position = keyWord.indexOf(sorted_key[i],last+1);
    // store the next position in the map
    indices.put(sorted_key[i],position);
    for(int j = 0; j < row; j++) {
        matrix[j][position] = cipher_array[count];
        count++;
    }
}
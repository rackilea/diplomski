public boolean hasTriples(int[] list) {
    for (int i = 0; i < list.length; i++){
        int duplicates = 0;

        for (int j = i+1; j < list.length; j++){
            if (list[i] == list[j]) {
                duplicates++;
                if (duplicates >= 3) return true;
            }
        }
    }
    return false;
}
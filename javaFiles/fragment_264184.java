for (int i = 0; i < towns.length(); i++) {
    int e = 0; // <<== Here
    for (int j = 0; j < towns[i].length(); j++) {
        if (towns[i].charAt(j) == 'o' || towns[i].charAt(j) == 'O') {
            e++;
        }
    }
    if (e > 3) {
        System.out.println(towns[i]);
    }
}
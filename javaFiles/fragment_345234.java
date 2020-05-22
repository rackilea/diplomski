while (in.hasNext()) {
    String[] words = in.nextLine().split("\t");

    for (int i = 0; i < 3; i++) {
        newArr.add(words[i]);
    }
}
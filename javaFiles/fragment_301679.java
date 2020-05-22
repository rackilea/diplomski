for (int i = 0; i < array.size() - 1; i++) {
        for (int j = i + 1; j < array.size(); j++) {
            update(array.get(i), array.get(j));
        }
    }
}
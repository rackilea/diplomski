public String getRandomValue(String key) {
    List<String> list = map.get(key);
    if (list == null) {
        return null; // or throw an exception
    }
    int randomIndex = RANDOM.nextInt(list.length());
    return list.get(randomIndex);
}
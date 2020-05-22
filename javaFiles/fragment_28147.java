List<String> ingredients = List.of(ingredientList);

while (entries.hasNext()) {
    Entry<String, String[]> entry = entries.next();

    String key = entry.getKey();
    String[] value = entry.getValue();

    if (Set.of(value).containsAll(ingredients)) {
        System.out.println("You could make " + key);
    }
}
// fast-enumerating food's values ("food" is an ArrayList<String>)
for (String item: foods) {
    // fast-enumerating map's values
    for (ArrayList<String> value: productsMap.values()) {
        // using ArrayList#contains
        System.out.println(value.contains(item));
    }
}
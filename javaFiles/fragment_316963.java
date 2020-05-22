public void showSubcategoriesRecursively() {
    showSubcategoriesRecursively(0);
}

private void showSubcategoriesRecursively(int index) {
    String spaces = IntStream.range(0, index).mapToObj(i -> "\t|_").collect(Collectors.joining());
    System.out.println(spaces + getName());
    getSubcategories().values().forEach(c -> c.showSubcategoriesRecursively(index + 1));
}
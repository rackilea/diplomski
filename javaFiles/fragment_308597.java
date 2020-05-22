int block = scan.nextInt();
int selectedCategoryIndex = block - 1;
if (selectedCategoryIndex >= 0 && selectedCategoryIndex < categories.size()) {
    Category selectedCategory = categories.get(selectedCategoryIndex);
    selectedCategory.run();
}
public static class Product {
        final private MainCategory category;
        private Category[] categories;

        public Product(MainCategory category) {
            this.category = category;
        }

        protected void checkCategoriesAreValid(Category... categories) {
            // throw an exception if at least one of the categories 
            // is not valid in respect of some business rules
            // by default any sub-category of a main one is ok
            List refs = Arrays.asList(category.getSubcategories());
            for(Category c:categories) {
                if (!refs.contains(c)) {
                    throw new IllegalArgumentException("...");
                }
            }
        }

        public Category[] getCategories() {
            return categories;
        }

        public void setCategories(Category... categories) {
            checkCategoriesAreValid(categories);
            this.categories = categories;
        }

    }
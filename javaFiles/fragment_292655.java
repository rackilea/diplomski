ArrayList<SubCategory> subCategoryMatches;

try {
    // Parsing json array response
    // loop through each json object

    for (int i = 0; i < response.length(); i++) {
        ...

        // New list
        subCategoryMatches = new ArrayList<SubCategory>();

        // Loop and add
        for (int j = 0; j < allSubCategory.length(); j++) {
            ...
            subCategoryMatches.add(subCategoryMatch);
        }

        // Add new list to outer list
        subcategory_name.add(subCategoryMatches);
    }
}
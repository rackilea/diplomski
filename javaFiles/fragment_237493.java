// INFO: variable dm is an instance of the documentManagement-Webservice

// 1.) read the folder of the Categories
Node categoryRoot = dm.getNodeByPath(configRoot.getID(), Arrays.asList("Categories"));

// 2.) find all Ids of the categories
List<Node> categories = dm.listNodes(categoryRoot.getID(), false);

if (categories != null) {
    for (Node category : categories) {
        if (category.getType().equals("Category")) {
            categoryIds.add(category.getID());
        }
    }
}

// 3.) Read all defintitions of the categories
List<AttributeGroupDefinition> categoryDefinitions = dm.getCategoryDefinitions(categoryIds);
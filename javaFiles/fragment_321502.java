private static String CATEGORY_NAME = "UI1"; 
List<ICategory> findCategories = workItemCommon.findCategories(projectArea, ICategory.FULL_PROFILE, monitor); 
    for(ICategory category : findCategories) { 
          if(category.getName().contains(CATEGORY_NAME)){ 
              filedAgainstAttribute = QueryableAttributes.getFactory(IWorkItem.ITEM_TYPE).findAttribute(projectArea, IWorkItem.CATEGORY_PROPERTY, auditableClient, monitor); 
                    filedAgainstExpression = new AttributeExpression(filedAgainstAttribute, AttributeOperation.EQUALS, category);
       } 
  }
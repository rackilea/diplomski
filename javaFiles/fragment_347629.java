activityStandardAttributeValue.setProduct(
    (standardAttributeForm != null && standardAttributeForm.getProduct() != null)
        ? standardAttributeForm.getProduct()
        : (groupedStandardAttributeForm != null
            ? groupedStandardAttributeForm.getProduct()
            : null));
activityStandardAttributeValue.setProject(
    (standardAttributeForm != null && standardAttributeForm.getProject() != null)
        ? standardAttributeForm.getProject()
        : (groupedStandardAttributeForm != null
            ? groupedStandardAttributeForm.getProject()
            : null));
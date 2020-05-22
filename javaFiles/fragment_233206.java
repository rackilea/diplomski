private void setRelationModel(ContentSlotForPageModel rel, ContentSlotModel slot, String id) {
    rel.setPage(firstContentPage);
    rel.setContentSlot(slot);
    rel.setPosition("no");
    setCMSRelationModel(rel);
}

private void setRelationModel(ContentSlotForTemplateModel rel, ContentSlotModel slot, String id) {
    rel.setPageTemplate(template);
    rel.setContentSlot(slot);
    rel.setPosition("no");
    setCMSRelationModel(rel);
}

private void setCMSRelationModel(CMSRelationModel rel, String id) {
    rel.setUid(id);
    rel.setCatalogVersion(catalogVersionModel);
    modelService.save(rel);
}
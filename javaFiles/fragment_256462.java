sourceAssetAttribute = new Attribute();
  sourceAssetAttributeData = new Data();
  sourceAssetAttribute.setName("attribute_name");

sourceAssetAttributeData.getStringLists().add(0,"Asset_type:"+asset_id));
sourceAssetAttributeData.getStringLists().add(1,"Asset_type:"+asset_id));

sourceAssetAttribute.setData(sourceAssetAttributeData);
sourceAsset.getAttributes().add(sourceAssetAttribute);
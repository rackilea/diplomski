String tagId = entry.getKey();
String tagDescription = entry.getValue();
String tagValue = additionalDetails.get(tagId);


plan.addFeature(new Feature(tagId, tagDescription, tagValue));
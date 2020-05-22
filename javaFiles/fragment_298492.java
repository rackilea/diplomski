Plan plan = new Plan(planId);


Map<String, String> planDetails = planMap.get(planId);
Iterator<Entry<String, String>> features = planDetails.entrySet().iterator();


Map<String, String> additionalDetails = planAdditionalDetailsMap.get(planId);


while (features.hasNext())
{
    Entry<String, String> entry = features.next();


 String tagId = entry.getKey();
String tagDescription = entry.getValue();
String tagValue = additionalDetails.get(tagId);


plan.addFeature(new Feature(tagId, tagDescription, tagValue));


}
return plan;
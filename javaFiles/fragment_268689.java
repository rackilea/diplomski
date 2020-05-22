ArrayList<LazyLoadedOption> optionsList = new ArrayList<LazyLoadedOption>();

FieldConfig fieldConfig = platRelOnAPIField.getRelevantConfig(issue);

OptionsManager optionManager = ComponentAccessor.getOptionsManager();

platOptions = optionManager.getOptions(fieldConfig);

for(def i = 0;i<platOptions.size();i++){
    def optVal = platOptions.get(i).getValue();
    if(platOptions.get(i).getValue().equals("custom field value")){
      optionsList.add(platOptions.get(i));
    break;
    }
}
platRelOnAPIField.updateValue(null, issue, new ModifiedValue(issue.getCustomFieldValue(platRelOnAPIField), optionsList),changeHolder)
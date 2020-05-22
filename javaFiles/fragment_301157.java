private String getUser(){
    for (FieldConfigScheme context : getConfigurationSchemes()) {
        if (processOptions(context)) {
            break;
        }
    }
    return this.user;
}

private boolean processOptions(FieldConfigScheme context){
    for (Option option : getOptions(context)) {
        if (processGroups(option)) {
            return true;
        }
    }
    return false;
}

private boolean processGroups(Option option){
    for (Group group : getGroups()) {
        if (option.getValue().equalsIgnoreCase(group.getName())) {
            this.user = group.getUser();
            return true;
        }
    }
    return false;
}
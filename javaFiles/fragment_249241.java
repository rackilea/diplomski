for (int counter = 0; counter < fields.size(); counter++) {
    String field = fields.get(counter);
    for (int iterator = 0; iterator < setters.size(); iterator++) {
        String setter = setters.get(iterator);
        for (int tickah = 0; tickah < methodName.size(); tickah++) {
            String updatedMethodName = methodName.get(tickah);
            for (int wicked = 0; wicked < updatedFieldName.size(); wicked++) {
                String updatedFieldNames = updatedFieldName.get(wicked);
                creatingMethod(updatedMethodName, updatedFieldNames, field, setter);
            }
        }
    }
}
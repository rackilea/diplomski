DescribeSObjectResult[] objects = myConnection.describeSObjects(sObjects);
for (int i = 0; i < objects.length; i++) {
    // object #i is stored in desObj variable.
    DescribeSObjectResult desObj = objects[i];
    // Get the name of the sObject
    String objectName = desObj.getName();
    boolean customFieldExists = false;
    // Iterate through the fields to get properties of each field
    for (int j = 0; j < fields.length; j++) {
        Field field = fields[j];
        if ("customField__c".equals(field.getName())) {
            extIdExists = true;
        }
        // If field is the last of the object
        if (j == fields.length - 1) {
            // Create a new custom field
            CustomField customField = new CustomField();
            // Add its properties to the custom field
            customField.setFullName(objectName + "." + customField__c);
            customField.setLabel("customField");
            customField.setType(FieldType.Text);
            customField.setExternalId(true);
            customField.setLength(18);
            // Push it to the object
            metadataConnection.create(new Metadata[] {customField});
            System.out.println("Created customField__c field in object " + objectName);
        }
    }
}
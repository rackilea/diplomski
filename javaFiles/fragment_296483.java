Map<Long, String> attfieldMap = null;
attfieldMap = view.getNameMap(form);

List<Field> oldValues = new ArrayList<Field>();
if (itemId != 0) {

    Item dom = getRecord();

    Map<FormField, Object> tempValues = dom.getValues();

    for (Map.Entry<FormField, Object> values : tempValues
            .entrySet()) {
        Field oldFld = new Field();
        Form form = (Form) values.getKey();

        if (attfieldMap.get(form.getField().getId()) != null) {
            oldFld.setKey(attfieldMap.get(form.getField()
                    .getId()));
            oldFld.setValue(values.getValue());

            oldValues.add(oldFld);
        }
    }
}

List<Field> otherFields = new ArrayList<Field>();
Field [] auditMapArray = new Field[oldValue.size()];
int index;
for (Map.Entry<Long, String> attfieldEntry : attfieldMap.entrySet()) {
    // Mandates to declare within loop
    Field attributeFld = new Field;

    attributeFld.setKey(attfieldEntry.getValue());
    attributeFld.setValue(String.valueOf(attfieldEntry.getKey()));

    index = oldValues.indexOf(attributeFld);
    if (index > 0) {
        auditMapArray[index] = attributeFld;
    }
    else
    {
        System.err.println(attributeFld + " not found in oldValues");
        otherFields.add(attributeFld);
    }
}

List<Field> auditMap = Arrays.asList(auditMapArray);
auditMap.addAll(otherFields);
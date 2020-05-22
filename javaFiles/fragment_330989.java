if (List.class.isAssignableFrom(incomingField.getType())) {
    List<?> thisList = (List<?>) incomingField.get(incomingObject);
    for (int k = 0; k < thisList.size(); k++) {
        Object occurrence = thisList.get(k);
        Object result = updateIncomingObject(occurrence);
        thisList.set(k, occurrence);
    }
}
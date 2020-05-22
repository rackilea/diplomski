if (incomingField.getType().isArray()) {
   Object[] thisArray = (Object[]) incomingField.get(incomingObject);
   for (int k = 0; k < thisArray.length; k++) {
      Object occurrence = thisArray[k];
      Object result = updateIncomingObject(occurrence);
      thisArray[k] = result;
   }
   incomingField.set(incomingObject, thisArray);
}
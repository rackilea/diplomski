public void validateForUpdate(ValidationResult validationResult) {
     super.validateForUpdate(validationResult);

     ObjectStore objectStore = (ObjectStore) getObjectContext().getGraphManager();
     DataRow snapshot = objectStore.getCachedSnapshot(getObjectId());
     if(!snapshot.get("COLUMNNAME").equals(getMyProperty())) {
        validationResult.addFailure(new SimpleValidationFailure(this, "Immutable property modified");
     }
  }
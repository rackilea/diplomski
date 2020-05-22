GraphqlFieldVisibility blockedFields = BlockedFields.newBlock()
      .addPattern("ApiField.secretfield")
      .addPattern(".*\\.secretAdminMutation") 
      .build();

private RuntimeWiring buildWiring() {
    return RuntimeWiring.newRuntimeWiring().fieldVisibility(blockedFields)....
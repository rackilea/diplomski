private void initConfig() {
    IdentityConfigurationBuilder builder = new IdentityConfigurationBuilder();

    builder
        .named("default")
            .stores()
                .jpa()
                    .mappedEntity(
                            AccountTypeEntity.class,
                            RoleTypeEntity.class,
                            GroupTypeEntity.class,
                            IdentityTypeEntity.class,
                            RelationshipTypeEntity.class,
                            RelationshipIdentityTypeEntity.class,
                            PartitionTypeEntity.class,
                            PasswordCredentialTypeEntity.class,
                            AttributeTypeEntity.class,
                            CustomUserEntity.class
                            )
                    .supportGlobalRelationship(Relationship.class)
                    .addContextInitializer(this.contextInitializer)
                    .addCredentialHandler(PasswordCredentialHandler.class)
                    .supportAllFeatures();
    identityConfig = builder.build();
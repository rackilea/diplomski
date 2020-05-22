TypeSpec planetTypeSpec = 
 TypeSpec.enumBuilder("Planet")
      .addModifiers(Modifier.PUBLIC)
      .addEnumConstant("MERCURY", TypeSpec.anonymousClassBuilder("$L, $L",3,2).build())
      .addEnumConstant("VENUS", TypeSpec.anonymousClassBuilder("$L, $L",4,6).build())
      .build();
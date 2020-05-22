TypeSpec userRepository = TypeSpec.interfaceBuilder("UserRepository")
                .addAnnotation(Repository.class)
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(ParameterizedTypeName.get(ClassName.get(PagingAndSortingRepository.class),  
                                                      ClassName.get(User.class),
                                                      ClassName.get(Long.class)))
                .build();
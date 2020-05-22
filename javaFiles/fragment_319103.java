TypeSpec.classBuilder("GeneratedClass")
            .addModifiers(Modifier.PUBLIC)
            .addSuperinterface(MyService.class)
            .addAnnotation(
                    AnnotationSpec.builder(AutoService.class).addMember(
                    "value", "$T.class", MyService.class).build()
            ).build();
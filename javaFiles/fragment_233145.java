final Validator validator = ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                .with(new GetterTester())
                .with(new SetterTester())
                .with(new ReflectionToStringTester())
                .build()

final List<PojoClass> pojos = PojoClassFactory.getPojoClassesRecursively("com.myProject.component.model", new FilterClassName("\\w*Dto*\$"))
Assert.assertTrue(validator.validate(pojos));
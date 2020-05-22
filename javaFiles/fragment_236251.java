BaseService service = TypedActor.newInstance(BaseService.class,
                                                     new TypedActorFactory() {
            public TypedActor create() {
                return new BaseActor("someString", 12);
            }
        });
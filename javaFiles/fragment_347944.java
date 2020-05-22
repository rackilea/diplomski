factory.classMap(A.class, B.class)
            .customize(
                    new CustomMapper<A, B>() {
                        @Override
                        public void mapAtoB(A a, B b, MappingContext context) {
                            SomeObject someObject = new SomeObject();
                            someObject.setStringSomeObject(a.getStringA());
                            b.getSomeObjects().add(someObject);
                        }
                    }
            )
            .byDefault()
            .register();
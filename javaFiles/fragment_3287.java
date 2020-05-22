sessionFactory = new AnnotationConfiguration()
                    .addPackage("test.animals") //the fully qualified package name
                    .addAnnotatedClass(Flight.class)
                    .addAnnotatedClass(Sky.class)
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(Dog.class)
                    .addResource("test/animals/orm.xml")
                    .configure()
                    .buildSessionFactory();
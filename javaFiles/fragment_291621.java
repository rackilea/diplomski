public void testOr() {
        Result result = new Result();
        Variable<Person> personV = declarationOf( Person.class );
        Variable<Person> markV = declarationOf( Person.class );
        Variable<String> nameV = declarationOf( String.class );

        Rule rule = rule( "or" )
                .build(
                        or(
                                pattern( personV ).expr("exprA", p -> p.getName().equals("Mark")),
                                and(
                                        pattern( markV ).expr("exprA", p -> p.getName().equals("Mark")),
                                        pattern( personV ).expr("exprB", markV, (p1, p2) -> p1.getAge() > p2.getAge())
                                )
                        ),
                        pattern( nameV ).expr("exprC", personV, (s, p) -> s.equals( p.getName() )),
                        on(nameV).execute( result::setValue )
                );

        Model model = new ModelImpl().addRule( rule );
        KieBase kieBase = KieBaseBuilder.createKieBaseFromModel( model );

        KieSession ksession = kieBase.newKieSession();

        ksession.insert( "Mario" );
        ksession.insert(new Person("Mark", 37));
        ksession.insert(new Person("Edson", 35));
        ksession.insert(new Person("Mario", 40));
        ksession.fireAllRules();

        assertEquals("Mario", result.getValue());
    }
public SomeEntity doSomething (String someAttribute, String anotherAttribute) {
   Something something; 
   EntityUtil.executeWithEntityManager(new EntityManagerAction() {
        public void execute(EntityManager em ) {

        /*
         * ... independent logic ...
         */
         //use the passed in 'em' here.
        }
    });

    return something;
}
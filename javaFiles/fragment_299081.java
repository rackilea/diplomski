CollectionUtils.filter( personList, new Predicate<Person>() {
    @Override
    public boolean evaluate( Person p ) {
        return p.getName() != null && p.getName().equals( "Nick" );
    }
});
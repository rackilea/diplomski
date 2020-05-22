private Map<Person, Boolean> map = new ConcurrentHashMap<>();
    public void update(final Person person) {
     if (person.getId() == -1) {
        if(map.putIfAbsent(person, true)==null){
           mService.getPersonDetails()
                 .flatMap(..)
                 .skip(..)
                 .doOnTerminate(()->map.remove(person))
                 .subscribe(personResult -> person.setId(personResult.getId()))
        }
     }
}
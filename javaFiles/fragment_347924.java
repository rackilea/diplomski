private final Exchanger<Person> waitingPerson = new Exchanger<Person>();

public Person getWaitingPerson(Person person, int timeoutMS) 
        throws InterruptedException, TimeoutException {
    return waitingPerson.exchange(person, timeoutMS, TimeUnit.MILLISECONDS);
}
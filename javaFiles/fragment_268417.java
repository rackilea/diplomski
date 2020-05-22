public class Data {
// your existing stuff
@OneToOne(fetch = FetchType.EAGER)
@JoinColumn("person_id")
private Person person;
// getters and setters
}

public class Person {
// your existing stuff
@OneToOne
private Data data;
// getters and setters
}
public class Person {
private int id_person; (primary key)
....
}


public class Group {
private int id_group; (primary key)
......
}

public class PersonGroup {
private int id_person_group (primary key)
private int id_person
private int id_group
....
}
public interface PersonType {}

public enum StudentType implements PersonType {
   Senior, Junior;
}

public enum SimplePerson implements PersonType {
    Teacher, Staff;
}
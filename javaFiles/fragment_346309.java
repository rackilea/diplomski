enum EventType {
    EMP_ID,
    EMP_NAME,
    ....
}


interface Event {
    EventType getType();   // instead of getName() which returns a String
}
long y = 1234;

for (String e2 : array2) {
    Event event = EventFactory.createSpecificEvent(e2, y);
    System.out.println(event.getClass().getName());
}
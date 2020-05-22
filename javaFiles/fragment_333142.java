DefaultGameEventHandler<GameEvent<EventType, AttributeType>, EventType, AttributeType> handler = new DefaultGameEventHandler<>();
GameEvent<EventType, AttributeType> event = new GameEvent<>();
event.addMessage(MyAttributeTypes.ATT_1, "some Message");
event.init(MyEventTypes.TYPE_1);
handler.handleEvent(event);
EventType type = event.getType();
// To switch on the type you could use the asEnum() method
// and cast the type to the corresponding enum if possible:
if (type.asEnum().getClass() == MyEventTypes.class) {
    MyEventTypes t = (MyEventTypes)type.asEnum();
    switch (t) {
        case TYPE_1:
            System.out.println("TYPE_1");
            break;
        case TYPE_2:
            System.out.println("TYPE_2");
            break;
        case TYPE_3:
            System.out.println("TYPE_3");
            break;
        default:
            break;
    }
}
// Or you could also directly switch on the name of the enum (not recommended!):
switch (type.asEnum().name()) {
    case "TYPE_1":
        System.out.println("TYPE_1");
        break;
    case "TYPE_2":
        System.out.println("TYPE_2");
        break;
    case "TYPE_3":
        System.out.println("TYPE_3");
        break;
    default:
        break;
}
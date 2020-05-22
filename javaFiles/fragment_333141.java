//MyEventTypes and MyAttributeTypes are enums implementing EventType respectively AttributeType
DefaultGameEventHandler<GameEvent<MyEventTypes, MyAttributeTypes>, MyEventTypes, MyAttributeTypes> handler = new DefaultGameEventHandler<>();
GameEvent<MyEventTypes, MyAttributeTypes> event = new GameEvent<>();
event.addMessage(MyAttributeTypes.ATT_1, "some Message");
event.init(MyEventTypes.TYPE_1);
handler.handleEvent(event);
switch (event.getType()) {
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
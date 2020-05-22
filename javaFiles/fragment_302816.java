class BaseEvent {
}

class ComplexEvent extends BaseEvent {
    int importantData;
    public ComplexEvent(int i) {
        importantData = i;
    }
}
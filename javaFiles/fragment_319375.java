private static final EventListener<Event> LISTENER = new EventListener<Event>() {
    @Override
    public void onEvent(Event event) {
        event.getTarget(); // the specific button clicked
    }
}

@Wire
private Menuitem contatti;
@Wire
private Menuitem listeDiDistribuzione;

@Override
public void doAfterCompose(Component component) {
    contatti.addEventListener(Events.ON_CLICK, LISTENER);
    listeDiDistribuzione.addEventListener(Events.ON_CLICK, LISTENER);
}
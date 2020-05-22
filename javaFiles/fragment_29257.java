class SuperEvent extends GenericEvent { }

class EventOne extends SuperEvent { }

class EventTwo extends SuperEvent { }

class FormPresenter {
  interface MyEventBinder extends EventBinder<FormPresenter> {}
  private final MyEventBinder eventBinder = GWT.create(MyEventBinder.class);

  FormPresenter(EventBus eventBus) {
    eventBinder.bindEventHandlers(this, eventBus);
  }

  @EventHandler
  void onEventOne(EventOne event) {
    // handler for EventOne
  }

  @EventHandler(handles = {EventOne.class, EventTwo.class})
  void onEventOneAndTwo(SuperEvent event) {
    // handler for EventOne and EventTwo
  }

  @EventHandler(handles = {EventOne.class, EventTwo.class})
  void onEventOneAndTwo2() {
    // handler for EventOne and EventTwo without parameter
  }
}
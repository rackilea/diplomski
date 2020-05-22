@Override
public void onCreate() {
    ...
    EventBus.getInstance().subscribe(this, MyType.class);
}

@Override
public void onDestroy() {
    ...
    EventBus.getInstance().unsubscribe(this, MyType.class);
}

@Override
public void newEvent(Object event) {
    if (event instanceOf MyType) {
        // do stuff
    }
}
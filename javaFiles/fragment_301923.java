public  SomeOtherStrangeClass(myEventListener listener) {
        EventThrower eventThrower = new EventThrower();
        eventThrower.addListener(listener);
        Log.v("[Listener]", "Throwing event");
        eventThrower.someEvent(13);
    }
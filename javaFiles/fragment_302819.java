public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.addListener(EventType.SimpleEvent, new Listener<BaseEvent>() {
            @Override
            public void handle(BaseEvent event) {
                log.info("Simple 1 handled!");
            }
        });
        eventSource.addListener(EventType.SimpleEvent2, new Listener<BaseEvent>() {
            @Override
            public void handle(BaseEvent event) {
                log.info("Simple 2 handled!");
            }
        });
        // compile error! we must handle ComplexEvent type
//        eventSource.addListener(EventType.ComplexEvent1, new Listener<BaseEvent>() {
//            @Override
//            public void handle(BaseEvent event) {
//                log.info("Complex 1 handled!");
//            }
//        });
        eventSource.addListener(EventType.ComplexEvent1, new Listener<ComplexEvent>() {
            @Override
            public void handle(ComplexEvent event) {
                log.info("Complex 1 handled!" + event.importantData);
            }
        });
        eventSource.addListener(EventType.ComplexEvent2, new Listener<ComplexEvent>() {
            @Override
            public void handle(ComplexEvent event) {
                log.info("Complex 2 handled!" + event.importantData);
            }
        });
        eventSource.fire(EventType.SimpleEvent, new BaseEvent());
        eventSource.fire(EventType.SimpleEvent2, new BaseEvent());
        eventSource.fire(EventType.ComplexEvent1, new ComplexEvent(1));
        eventSource.fire(EventType.ComplexEvent2, new ComplexEvent(2));
        // compile error! we must fire ComplexEvent to our listeners
        //eventSource.fire(EventType.ComplexEvent1, new BaseEvent());
    }
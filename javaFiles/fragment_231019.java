public static void addRandomEvents(Events[] events) {
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            int randomEventIndex = random.nextInt(eventNames.length);
            String randomEventName = eventNames[randomEventIndex];
            String randomEventTime = new Date().toString();
            int randomPriority = random.nextInt(events.length);
            Events randomEvent = new Events(randomEventTime, randomEventName, randomPriority);
            events[i] = randomEvent;
        }
    }
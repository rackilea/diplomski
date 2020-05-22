int loop = 0; // loop counter
    while (loop < EventsCollect.size()) {
        if (EventsCollect.get(loop).size() < 200000) {
            EventsCollect.remove(loop);
        }
        else
            loop++;
    }
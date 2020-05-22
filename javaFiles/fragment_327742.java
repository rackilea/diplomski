@Override
public void update(Observable o, Object arg) {
    ArrayList<Message> messages = new ArrayList<Message>();
    if (arg instanceof ArrayList<?>)
        for (Object o : (ArrayList<?>) arg)
            if (o instanceof Message)
                messages.add((Message) o);

    // Do stuff with the messages list
}
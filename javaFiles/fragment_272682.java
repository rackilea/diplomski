public void onReceive(Object message) throws Exception {

    if (message.equals("start")) {
        child.tell("fetch something for me!", getSelf());
        getContext().setReceiveTimeout(Duration.create("1 second"));
    }

    else if (message.equals("child's response")) {
        getContext().setReceiveTimeout(Duration.Undefined()); //turn off receive timeout
        // handle a response from a child here
    }

    else if (message instanceof ReceiveTimeout) {
        getContext().setReceiveTimeout(Duration.Undefined()); //turn off receive timeout
        // handle situation where I did not get a response in time
    }
 }
...
    else if(message.matches("^(P)(\\d)+(\\,)(\\s)(.)*")) {
        String[] split = message.split(", ");
        displayPocketCards("resources/10C.png");
    }
}
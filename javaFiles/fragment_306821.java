List<ParseMessage> cntct = /*...*/;

// Build map of contact to most recent message
Map<String, ParseMessage> cntctMap = cntct.stream().collect(Collectors.toMap(
        ParseMessage::getContact,
        Function.identity(),
        (a, b) -> a.getDateSent() >= b.getDateSent() ? a : b
));
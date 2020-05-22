String myItem = gadgets
        .stream()
        .peek(YourClass::accept)
        .filter(YourClass::test)
        .findFirst()
        .orElse("");
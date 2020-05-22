yourStream
    .filter(..)
    .findAny() //returns Optional
    .ifPresentOrElse(
        // action when value exists 
        value -> System.out.println("There was a value "+value),
        // action when there is no value
        () -> System.out.println("No value found")
    );
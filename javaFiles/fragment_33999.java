// Using the 'try with resource' construct
    try (Reader r = new FileReader(...)) {
        // use the reader
    } catch (IOException ex) {
        // ...
    }
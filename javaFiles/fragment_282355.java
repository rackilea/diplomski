public Entry(String name) {
    this.name = name;
    this.filename = this.name + ".ser";

    // Don't call it here. Your object hasn't been fully constructed yet.
    // serialize();  
}
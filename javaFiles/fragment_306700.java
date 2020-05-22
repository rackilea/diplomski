class MyFunction {
    void run() {
       Pigeon first = new Pigeon();
       // the following line will NOT compile
       first.bark();
       // and neither will this. Because a Pigeon is not a Dog.
       ((Dog)first).bark();
    }
}
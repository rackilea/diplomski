class YourClass {

    static Comparator<YourClass> getAttribute1Comparator() {
        return new Comparator<YourClass>() {
            // compare using attribute 1
        };
    }

    static Comparator<YourClass> getAttribute2Comparator() {
        return new Comparator<YourClass>() {
            // compare using attribute 2
        };
    }
}
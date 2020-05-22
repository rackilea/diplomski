Slide s = new Slide(); 
s.move(...);

// or

class Slide {
    void move (...) { 
        ... 
    }
    void method () {
        move(...);
    }
}

// or

class Slide {
    static void move (...) { 
        ... 
    }
    static void method () {
        move(...);
    }
}
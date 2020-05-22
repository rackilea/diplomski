Slide.move(...); // error: move requires an instance

// and

class Slide {
    void move (...) { 
        ... 
    }
    static void method () {
        move(...); // error: method is static, there is no instance
    }
}
class Main {
    static Main m;
    public static void main (String [] args) {
        // use m
    }
} 

class MainSub1 extends Main { static { m = new MainSub1(); } } 
class MainSub2 extends Main { static { m = new MainSub2(); } }
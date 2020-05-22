class Anything {   // Your class name should start with uppercase letters.
    private static int counter = 0;

    public String toString() { 
        ++counter; 
        return "the time this method is being called is number " +counter; 
    }
}
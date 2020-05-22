public static void main(String[] args) {
    // using a supertype reference
    Polygon a = new Rectangle();
    /** 
        there are two methods available here, the one inherited from Polygon and 
        the one Rectangle overrides. Dynamic binding ensures the right method gets 
        picked up at runtime, based on the actual type of the Polygon object 
        (which in this case in Rectangle)
    */
    a.getPerimeter();
}
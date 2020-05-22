new ArrayWalker<String>(array) {
    @Override
    public void function(String str) {
        System.out.println("This is a " + str + " color.");
    }
}.walk();
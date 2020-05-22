List<String> myListOfStrings = ...// some List

new IterableList<String>() { // missing ()
    public void action(String s) {
        // do something
    }
}.perfrom(myListOfStrings);
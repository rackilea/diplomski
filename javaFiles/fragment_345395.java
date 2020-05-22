public OrderedIntList(int... elements) {
    for (int i = 0; i < elements.length; i++) {
        this.add(elements[i]);// your class extends ArrayList 
                              // so it inherited structure to store elements
                              // and toString is base on this structure
                              // not on local list declared in constructor
    }
}
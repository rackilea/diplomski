class TopLevel {
    @Override public String serializeToString() {
        return super.serializeToString() // calls SecondLevel implementation 
                + ", topLevelAttribute: 1";
    }
}

class SecondLevel {
    @Override public String serializeToString() {
        return super.serializeToString() // calls Base implementation 
                + ", secondLevelAttribute: 2";
    }
}

// and so on ...
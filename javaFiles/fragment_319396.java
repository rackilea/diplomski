public void Observation (String observed) {
    boolean found = false;
    for (Bird x : getBirds()) { // this has to be a method
        if (x.getName() != null && x.getLatin() != null && x.getName().contains(observed) || x.getLatin().contains(observed)) {
            System.out.println("Done");
            System.out.println("");
            x.increaseCount();
            found = true;      
        } 
    }
    if (!found) {
            System.out.println("Not a bird");
    }
}
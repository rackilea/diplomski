public void Observation (String observed) {

    for (Bird x : getBirds()) { // this has to be a method
        if (x.getName() != null && x.getLatin() != null && x.getName().contains(observed) || x.getLatin().contains(observed)) {
            System.out.println("Done");
            System.out.println("");
            x.increaseCount();      
        } 
         /* No need to print "Not a bird" for every mismatch. Use a flag instead */
        else if (x.getName() != observed || x.getLatin() != observed) {
            System.out.println("Not a bird");
        }
    }
}
public void addObserver(Observer o){
    // Calls the method addObserver of the class Observable
    super.addObserver(o);
    System.out.println("New observer added!");
    this.obs.add(o);
}
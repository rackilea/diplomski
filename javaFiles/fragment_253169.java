// here you declare an instance variable named minefield
Minefield minefield;

public void initialize() {
    System.out.println("Begin Setup");

    // here, instead of initializing the instance variable, 
    // you declare a local variable with the same name
    // it should be: minefield = new Minefield();
    // or: this.minefield = new Minefield();
    Minefield minefield = new Minefield();
    minefield.makeMinefield();
}
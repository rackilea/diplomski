private static Crate[] crates = new Crate[3];        

public LevelOne(){
    crates[0] = new Crate(); // <= add this
    crates[0].setX(200);
    crates[0].setY(200);
    // same for other elements
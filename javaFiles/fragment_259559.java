class Unit{
    MovementStrategy ms;      
    final int baseMovement;
    int x,y;

    public Unit(int baseMovement){
        this.baseMovement = baseMovement;
    }

    abstract void fire();

    void moveForward(){
        x = x + ms.getHexagonsToMove(baseMovement);
    }

    void setMovementStrategy(MovementStrategy ms){
        this.ms = ms;
    }
}
interface MovementStrategy{
    public int getHexagonsToMove(int base);
}

class PlainMovementStrategy implements MovementStrategy{
    public int getHexagonsToMove(int base){
        return base;
    }
}

class RailroadMovementStrategy implements MovementStrategy{
    public int getHexagonsToMove(int base){
        return base*3;
    }
}

class ForestMovementStrategy implements MovementStrategy{
    public int getHexagonsToMove(int base){
        return (int)(base/2);
    }
}
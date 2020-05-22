abstract class ChessPiece { 
    abstract void move(Board board);
}

class Knight extends ChessPiece { 
    @Override 
    public void move(Board board) { 
    //...weeee, I'm a Knight
    }
}

class Bishop extends ChessPiece { 
    @Override 
    public void move(Board board) { 
    //...weeee, I'm a Bishop
    }
}
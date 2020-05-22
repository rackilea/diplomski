@Override
public Object clone()   {
    try {
        MinimaxBoard cloned = (MinimaxBoard)super.clone();
        cloned.boardArray = (char[][])boardArray.clone();
        for(int row=0; row< cloned.boardArray.length;row++)
            cloned.boardArray[row] = (char[])boardArray[row].clone();
        return cloned;
    }
   catch(CloneNotSupportedException e) {
        return null;
    }
}

}
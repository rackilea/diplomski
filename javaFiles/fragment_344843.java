class Square
{
    int buttonId;
    int rownum;
    int colnum;
    int state;    // can be empty || white || black
    //.. maybe more things you want to store   

    // some functions:
    void addPiece();
    void removePiece();
    void setButtonId(int id);

}

class Board
{
    // 2D array of Squares e.g. ArrayList<ArrayList<Square>>

    // some functions:
    void createEmptyBoard()    // which creates an empty board    
    ArrayList<ArrayList<Square> getAllSquares();
    ArrayList<Square> getAllWhiteSquare();
    ArrayList<Square> getAllBlackSquares();

}


/**
* You Activity should be able to draw the board, without any knowledge of the 
* underlying data. Vice Versa: your Board class, should know exactly where all
* pieces are, and what color they have, but should not care about what happens
* when they are clicked. Or, if they can be clicked.
*
* Your activity only has to make sure, that if views are clicked/dragged or moved
* that the Board class will be updated accordingly
*/
class YourActivity
{
    Board board;

    // some methods:
    drawBoard(Board board)
    {
        ArrayList<Square> white = board.getAllWhiteSquares();
        ArrayList<Square> black = board.getAllBlackSquares();

        for(Square w : white){
            Button b = new Button();    // create a button
            w.setButtonId(b.getId());   // store the button id in the square

            b.setOnClickListener(new OnClickListener()
            {
                public void onClick(View v)
                {
                    Square clickedSquare = board.getSquareWithId(v.getId());
                }
            );
        }
    }
}
package routines;

import java.io.IOException;
import java.util.Random;

import game.*;

public class MovePlayer extends Routine {

    private final int destX;
    private final int destY;
    private final Random random = new Random();

    public MovePlayer(int destX, int destY, GameBoard board) throws IOException {
        super();
        try {
            if (destY > board.getHeight() || destX > board.getWidth()) {
                throw new IllegalArgumentException(">>> Error while creating routine, one or more coords are outside of the game board");
            } else {
            }
        } catch (IllegalArgumentException e) {
            fail();
        System.err.println(e.getLocalizedMessage());
    }
    this.destX = destX;
    this.destY = destY;
}
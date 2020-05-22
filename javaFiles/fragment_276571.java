public boolean isGameWon(Board board) {
    for (Point point : board.getTargetPoints())
        if(board.getTopSpriteAt(point).getSpriteType()!=SpriteType.BOX)
            return false;
    return true;
}
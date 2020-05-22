@Test
public void testPositiveEquals() {
   BoardPiece boardPieceOne = new BoardPiece("value");
   assertTrue(boardPieceOne.equals(boardPieceOne));
}

@Test
public void testNegativeEquals() {
   BoardPiece boardPieceOne = new BoardPiece("value");
   BoardPiece boardPieceTwo = new BoardPiece("no value");
   assertFalse(boardPieceOne.equals(boardPieceTwo));
}
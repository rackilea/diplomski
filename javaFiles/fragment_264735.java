Box deadWhitePieces = Box.createVerticalBox();
Box deadBloackPieces = Box.createVerticalBox();
Box deadPieces = Box.createVerticalBox();
deadPieces.add( deadBlackPieces );
deadPieces.add( Box.createVerticalGlue() );
deadPieces.add( deadWhitePieces );
frame.add(deadPieces. BorderLayout.LINE_START);
// store the position
btn[i][j].setUserData( new Position( btn.length - i, convCol( j + 1 ) ) );

// get it on mouse click
btn[i][j].setOnMouseClicked( ( MouseEvent e ) -> {
    StringBuilder str = new StringBuilder();
    str.append( "Position XY : " ).append( (( Node ) e.getSource()).getUserData() ).append( "\n" );
    text.appendText( str.toString() );
} );
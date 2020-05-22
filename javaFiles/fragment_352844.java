String[] arr = {"AAA","BBBB","CCC"};
Facts f = new Facts( array );
ButtonCreator creator = new ButtonCreator( f );

while( creator.canCreateNextButton() )
{
    Button button = creator.nextButton( //view context here// );
    button.setListener( //listener here// );    
}
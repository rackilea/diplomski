class StringToList extends Binding {
  def getVariable( String name ) {
    name
  }
  def toList( String list ) {
    new GroovyShell( this ).evaluate( list )
  }
}

String myString = "[[one, two], [three, four]]"
List myList = new StringToList().toList( myString )
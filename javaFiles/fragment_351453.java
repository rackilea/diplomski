class Evaluator extends Binding {
  def parse( s ) {
    GroovyShell shell = new GroovyShell( this );
    shell.evaluate( s )
  }
  Object getVariable( String name ) { name }
}

def inStr = '{key1=keyval, key2=[listitem1, listitem2], key3=keyval2}'
def inObj = new Evaluator().parse( inStr.tr( '{}=', '[]:' ) )

println inObj
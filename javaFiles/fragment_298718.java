// Dummy class for testing
abstract class MessageTest {
  abstract void onMessage( msg ) ;
  void done() { println "DONE!" }
}

// Create a Proxied instance of our class, with an empty onMessage method
def p = [ onMessage:{ msg -> } ] as MessageTest

// Then overwrite the method once we have access to the Proxy object p
p.metaClass.onMessage = { msg -> println msg ; p.done() }

// Test
p.onMessage( 'woo' )
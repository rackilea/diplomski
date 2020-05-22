import groovy.swing.SwingBuilder

...

public def setStatus( statusText ) {
  // If we are not already on the EDT, static SwingBuilder.build(Closure) will do that for us.
  // In the case of an event handler like the actionPerformed for the button, then naturally
  // we're on the EDT already and the building will continue immediately.
  SwingBuilder.build {

    // doOutside will run the following code in our own thread
    doOutside {

      // Then change the swing components back on the EDT
      edt {
        ljaStatusBarButton.text = "Status : $statusText . . . ."
      }

      // So this sleep is in our own thread again (from doOutside)
      sleep(3000)

      // Then change the swing components back on the EDT
      edt {
        ljaStatusBarButton.text = "Status : Waiting for user action . . . ."
      }
    }
  }
}
player.addControllerListener(new ControllerListener()

    { 

      public void controllerUpdate(ControllerEvent e) 

      {   

      if (e instanceof EndOfMediaEvent) 

        {   

        System.exit(0); 

        }

      } 

    }
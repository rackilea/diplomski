//this is for keep reading events from event table
while(!shell.isDisposed()){
        if(!display.readAndDispatch())
          display.sleep();
      }
      display.dispose();
Class ReceivedCommandEvent extends EventManager.EventObject {}   // define your event   

while (command==null) {
  command = pollDataBaseForCommand();  //poll your databae for commands
  waitForSomePeriod(); 
}

EventManager.triggerEvent(this, new ReceivedCommandEvent(command));     //trigger your event, with the command as payload
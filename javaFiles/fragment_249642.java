public void run(){
   ui.print(commandHandler.listCommands());

   while(true){
       if(commandHandler.continue()){
           ui.print(commandHandler.events());
       }
   }
}
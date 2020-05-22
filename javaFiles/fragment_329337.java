private final long PERIOD = 4000L; //timer
private long lastTime = System.currentTimeMillis() - PERIOD; 
String click = "";
String click2 = "";
@SubscribeEvent
    public void onChat(final ClientChatReceivedEvent e) { //look at the chat
        final String chat = e.message.getUnformattedText(); 
          if(chat.startsWith("Something")) { //if the chat message starts with "Something"
                //Create the string chatp1 being "Something 123"
                click = chatp1.replace("Something ", ""); //Creates a string "click", which is chatp1 without the "Something ", so it's "123"
//After it basically does the same thing multiple times, but instead of "Something" it's "Something1" and instead of "123" it's "124" etc.
//Then I need to run the commands
MyGame.getMyGame().thePlayer.sendChatMessage("/Command " + click); //runs the command "/Command 123"
          long thisTime12 = System.currentTimeMillis();
            if ((thisTime12 - lastTime) >= PERIOD) { //waits
                    lastTime = thisTime12;
MyGame.getMyGame().thePlayer.sendChatMessage("/Command " + click2); //Runs the command "/Command 124"
//etc.
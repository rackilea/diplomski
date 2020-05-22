public class MprovBot extends PircBot {

    // Get song title from Txt file AND return it!
    public String getSong() throws Exception {
        FileReader file = new FileReader ("song.txt");
        BufferedReader reader = new BufferedReader(file);

        String song = "";
        String line = reader.readLine();
        while (line != null){
            song += line;
            line = reader.readLine();
        } 

        return song;
    }

    // IRC Commands_
    public MprovBot() {
        this.setName("MprovBot");
    }

    public void onMessage(String channel, String sender,
        String login, String hostname, String message) {
        if (message.equalsIgnoreCase("!test")) {
            sendMessage (channel, "Test Done");
        }

        if (message.equalsIgnoreCase("!Command")) {
            sendMessage (channel, "This are the commands you can do.");
        }

        if (message.equalsIgnoreCase("!song")){
            String song = "";
            try {
                song = getSong();
            } catch(Exception e) { e.printStackTrace(); }
            sendMessage (channel, song);
        }
    }
}
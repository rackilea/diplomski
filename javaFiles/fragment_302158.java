class PlayerThread extends Thread {
    private final Player player;

    PlayerThread(Player player) {
        this.player = player;
    }

    public void run() {
        try {
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        String filename = "*filename*";
        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
            // load the file
            Player player = new Player(fileInputStream);
            // start playing music in separate thread
            new PlayerThread(player).start();

            // wait until you want to stop the music,
            // or do something else, maybe wait for user's decision
            Thread.sleep(10_000); // 10 seconds
            // close the player
            player.close();
        } catch (JavaLayerException | IOException e) {
            e.printStackTrace();
        }
    }
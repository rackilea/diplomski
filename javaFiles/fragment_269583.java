public void play() {
        String song = "http://www.ntonyx.com/mp3files/Morning_Flower.mp3";
        Player mp3player = null;
        BufferedInputStream in = null;
        try {
          in = new BufferedInputStream(new URL(song).openStream());
          mp3player = new Player(in);
          mp3player.play();
        } catch (MalformedURLException ex) {
        } catch (IOException e) {
        } catch (JavaLayerException e) {
        } catch (NullPointerException ex) {
        }

}
class Playlist implements LineListener {
    private final List<AudioInputStream> list = new ArrayList<>();
    private Clip clip;
    private int next;

    @Override
    public void update(LineEvent evt) {
        if(evt.getType() == LineEvent.STOP) {
            try {
                playNext();
            } catch(LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    void enqueue(AudioInputStream ais) {
        synchronized(this) {
            list.add(ais);
        }
    }

    void playNext() throws LineUnavailableException, IOException {
        synchronized(this) {
            if(list.isEmpty()) {
                throw new IllegalStateException();
            }
            if(clip != null) {
                if(clip.isRunning()) clip.stop();
                if(clip.isOpen()) clip.close();
            }

            clip = AudioSystem.getClip();
            clip.addLineListener(listener);
            try {
                clip.open(list.get(next));
            } finally {
                next = (next + 1) % list.size();
            }
            clip.start();
        }
    }
}
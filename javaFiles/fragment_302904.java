VideoPanel.getMediaPlayer().setRepeat(true);
VideoPanel.getMediaPlayer().setPlaySubItems(true);
VideoPanel.getMediaPlayer().prepareMedia(media, options);

try {
    Thread.sleep(2000);
} catch (InterruptedException e) {
    e.printStackTrace();
}

for(String s: VideoPanel.getMediaPlayer().subItems()) System.out.println(s);
VideoPanel.getMediaPlayer().play();
JButton playButton = new JButton("Play/Pause");
playButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        mediaPlayerComponent.getMediaPlayer.pause();
    }
});
protected void paintComponent(Graphics x) {
            super.paintComponent(x);
            int y = i % 25;

            Image showImg = new ImageIcon("bin/slide/" + y + ".png").getImage();
            super.paintComponent(x);
            x.drawImage((Settings.background).getImage(), 0, 0, getWidth(), getHeight(), this);
            x.drawImage(showImg, 360, 260, getWidth(), getHeight(), 0, 0, 110, 31, null);
}
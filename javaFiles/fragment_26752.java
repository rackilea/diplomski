private ImageIcon[] grasslevels = new ImageIcon[42];
for (int i = 0; i < grasslevels.length; ++i) {
    grasslevels[i] = new ImageIcon("/home/vishnu/workspace/game/bin/grasslevel"
        + i + ".png");
}
JButton k = new JButton("");
k.setIcon(grasslevels[i]);
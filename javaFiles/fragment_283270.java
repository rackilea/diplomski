ImageIcon ii = new ImageIcon("path-to-image");
int scale = 2; // 2 times smaller
int width = ii.getIconWidth();
int newWidth = width / scale;
yourComponent.setIcon(new ImageIcon(ii.getImage().getScaledInstance(newWidth, -1,
            java.awt.Image.SCALE_SMOOTH)));
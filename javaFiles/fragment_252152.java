@Override
public void actionPerformed(ActionEvent e) {
    if (clip != null) {
        if (clip.isActive()) clip.stop();
        if (clip.isOpen()) clip.close();
    }
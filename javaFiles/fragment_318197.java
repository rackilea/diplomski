@Override
public void actionPerformed(ActionEvent e) {
    if (time == 0) {
        rooster.play();
        c.setBackground(Color.BLACK);
        time += 5000;
    }
    else /*if (time == 5000)*/ {
        cow.play();
        c.setBackground(Color.WHITE);
        time = 0;
    }
}
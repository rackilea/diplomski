private boolean first = true;
public void mousePressed() {
    if (state == 0) {
        for (int i = 0; i < 6; i++) {
            if (mouseX >= cards[i].x && mouseX <= cards[i].x + cards[i].WIDTH && mouseY >= cards[i].y && mouseY <= cards[i].y + cards[i].HEIGHT) {
                cards[i].flip();
            }
        }
        if (first) {
            first = false;;
        } else {
            state = 1;
            // perhaps reset first?
        }
    }
}